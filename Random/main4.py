import tkinter as tk
import random

class SnakeGame:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Permainan Ular")
        self.canvas = tk.Canvas(self.window, width=400, height=300)
        self.canvas.pack()
        self.snake_positions = [(200, 100), (220, 100), (240, 100)]  # Awalan posisi ular
        self.food_position = self.generate_food()  # Generasi posisi makanan acak
        self.direction = 'right'
        self.score = 0

        self.draw_snake_and_food()
        self.bind_keys()
        self.game_loop()

    def generate_food(self):
        return (random.randint(40, 360), random.randint(30, 270))

    def draw_snake_and_food(self):
        self.canvas.delete(tk.ALL)
        for pos in self.snake_positions:
            self.canvas.create_rectangle(pos[0]-15,pos[1]-15,pos[0]+15,pos[1]+15,outline='black',fill='#000000')
        self.canvas.create_oval(self.food_position[0]-10,self.food_position[1]-10,
                                self.food_position[0]+10,self.food_position[1]+10,outline='red',
                                fill='red')

    def bind_keys(self):
        self.window.bind('<Key>', lambda event: self.change_direction(event.keysym))

    def change_direction(self,key):
      if key == 'Right': 
          self.direction ='right'

      elif key =='Left': 
          self.direction ='left'

      elif key =='Up': 
          self.direction ='up'

      elif key =='Down': 
          self.direction ='down'


   def game_loop(self):

     current_pos=self.snake_positions[-1]

     if self.direction == 'right':

         new_pos=(current_pos[0]+20,current_pos[1])

     elif self.direction == 'left':

         new_pos=(current_pos[0]-20,current_pos[1])
         
     elif self.direction == 'up':

         new_pos =(current_pos[0],current_pos[1]-20 )
          
     elif self.direction == 'down':

         new_pos =(current_pos[0],current_pos[1]+20 )

     
      
     

     self.snake_positions.append(new_pos)


     if new_pos in self.snake_positions[:-1]:
         self.game