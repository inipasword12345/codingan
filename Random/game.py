import pygame
import random
import sys

# Inisialisasi Pygame
pygame.init()

# Ukuran layar
screen_width = 800
screen_height = 600
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Game Tembak-Tembakan')

# Warna
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

# Kecepatan
player_speed = 5
bullet_speed = 10
enemy_speed = 2

# Ukuran objek
player_width = 50
player_height = 50
bullet_width = 5
bullet_height = 10
enemy_width = 50
enemy_height = 50

# Kelas untuk pemain
class Player:
    def __init__(self):
        self.rect = pygame.Rect(screen_width // 2, screen_height - player_height - 10, player_width, player_height)

    def move(self, dx):
        if self.rect.x + dx > 0 and self.rect.x + dx < screen_width - player_width:
            self.rect.x += dx

    def draw(self):
        pygame.draw.rect(screen, GREEN, self.rect)

# Kelas untuk peluru
class Bullet:
    def __init__(self, x, y):
        self.rect = pygame.Rect(x + (player_width // 2) - (bullet_width // 2), y, bullet_width, bullet_height)

    def move(self):
        self.rect.y -= bullet_speed

    def draw(self):
        pygame.draw.rect(screen, RED, self.rect)

# Kelas untuk musuh
class Enemy:
    def __init__(self):
        self.rect = pygame.Rect(random.randint(0, screen_width - enemy_width), 0, enemy_width, enemy_height)

    def move(self):
        self.rect.y += enemy_speed

    def draw(self):
        pygame.draw.rect(screen, BLACK, self.rect)

def main():
    clock = pygame.time.Clock()
    player = Player()
    bullets = []
    enemies = []
    score = 0

    # Loop utama permainan
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            player.move(-player_speed)
        if keys[pygame.K_RIGHT]:
            player.move(player_speed)
        if keys[pygame.K_SPACE]:
            bullets.append(Bullet(player.rect.x, player.rect.y))

        # Update posisi peluru dan musuh
        for bullet in bullets[:]:
            bullet.move()
            if bullet.rect.y < 0:
                bullets.remove(bullet)

        if random.randint(1, 30) == 1:  # Menambahkan musuh secara acak
            enemies.append(Enemy())

        for enemy in enemies[:]:
            enemy.move()
            if enemy.rect.y > screen_height:
                enemies.remove(enemy)

            # Cek tabrakan antara peluru dan musuh
            for bullet in bullets[:]:
                if bullet.rect.colliderect(enemy.rect):
                    bullets.remove(bullet)
                    enemies.remove(enemy)
                    score += 1
                    break

        # Gambar semua objek di layar
        screen.fill(WHITE)
        player.draw()
        
        for bullet in bullets:
            bullet.draw()

        for enemy in enemies:
            enemy.draw()

        # Tampilkan skor di layar
        font = pygame.font.SysFont(None, 36)
        score_text = font.render(f'Score: {score}', True, BLACK)
        screen.blit(score_text, (10, 10))

        pygame.display.flip()
        clock.tick(60)

if __name__ == "__main__":
    main()