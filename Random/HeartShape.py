import turtle
import random

def draw_heart():
    turtle.begin_fill()
    turtle.left(140)
    turtle.forward(180)
    turtle.circle(-90, 180)
    turtle.setheading(60)
    turtle.circle(-90, 180)
    turtle.forward(180)
    turtle.end_fill()

turtle.speed("fastest")
turtle.bgcolor("black")

colors = ["red", "pink", "purple"]
while True:
    x = random.randint(-300, 300)
    y = random.randint(-300, 300)
    turtle.penup()
    turtle.goto(x, y)
    turtle.pendown()
    color = random.choice(colors)
    turtle.color(color)
    draw_heart()
    
    # Glow effect by drawing a slightly bigger shape with low opacity
    turtle.penup()
    turtle.goto(x, y)
    turtle.pendown()
    turtle.color(color, color)
    turtle.begin_fill()
    turtle.fillcolor(color)
    turtle.fillcolor(color)
    turtle.pensize(4)
    draw_heart()
    turtle.pensize(1)

    # Move the heart
    turtle.penup()
    turtle.forward(10)
    turtle.left(10)
    turtle.pendown()

turtle.done()

