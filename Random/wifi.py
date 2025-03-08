import subprocess

def get_wifi_passwords():
    try:
        # Run the command to get Wi-Fi profiles
        profiles_data = subprocess.check_output("netsh wlan show profiles", shell=True).decode('utf-8', errors="backslashreplace")
        
        # Extract profile names
        profiles = [line.split(":")[1].strip() for line in profiles_data.split("\n") if "All User Profile" in line]
        
        # Get password for each profile
        wifi_passwords = {}
        for profile in profiles:
            try:
                # Run the command to get password info for the profile
                profile_info = subprocess.check_output(f"netsh wlan show profile {profile} key=clear", shell=True).decode('utf-8', errors="backslashreplace")
                
                # Extract the password from the profile info
                password_line = [line.split(":")[1].strip() for line in profile_info.split("\n") if "Key Content" in line]
                wifi_passwords[profile] = password_line[0] if password_line else "No password set"
            except subprocess.CalledProcessError:
                wifi_passwords[profile] = "Unable to retrieve password"
        
        return wifi_passwords
    except subprocess.CalledProcessError:
        return "Error: Unable to retrieve Wi-Fi profiles"

# Example usage
if __name__ == "__main__":
    passwords = get_wifi_passwords()
    for wifi, password in passwords.items():
        print(f"SSID: {wifi}, Password: {password}")

