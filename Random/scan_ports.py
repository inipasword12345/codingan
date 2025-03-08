import socket
import threading
from queue import Queue
import time

def scan_port(target, port, open_ports):
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.settimeout(1)  # timeout 1 detik
    result = sock.connect_ex((target, port))
    if result == 0:
        print(f"Port {port} terbuka")
        open_ports.append(port)
    sock.close()

def threader(target, q, open_ports):
    while True:
        port = q.get()
        scan_port(target, port, open_ports)
        q.task_done()

def scan_ports(target):
    start_time = time.time()
    print(f"Memulai pemindaian pada {target}...")
    
    open_ports = []
    q = Queue()

    # Membuat 100 thread worker
    for _ in range(100):
        t = threading.Thread(target=threader, args=(target, q, open_ports))
        t.daemon = True
        t.start()

    # Antrian port yang akan di scan
    for port in range(1, 1025):
        q.put(port)

    q.join()
    
    duration = time.time() - start_time
    print(f"\nPemindaian selesai dalam {duration:.2f} detik")
    print(f"Port yang terbuka: {sorted(open_ports)}")

if __name__ == "__main__":
    target_ip = input("Masukkan alamat IP target: ")
    scan_ports(target_ip)