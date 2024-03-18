import pandas as pd
import matplotlib.pyplot as plt

file_path = 'FuncSystem.csv'
df = pd.read_csv(file_path, names=['Input', 'Output'])

x = df['Input']
y = df['Output']

plt.figure(figsize=(8, 6))
plt.plot(x, y, marker='o', linestyle='-', color='b', label='Function')
plt.xlabel('Input')
plt.ylabel('Output')
plt.title(file_path)
plt.legend()

plt.grid(True)
plt.tight_layout()
plt.show()