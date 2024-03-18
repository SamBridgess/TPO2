import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV file
file_path = 'log/ln.csv'  # Update with your CSV file path
df = pd.read_csv(file_path, names=['Input', 'Output'])

# Get Input and Output columns
x = df['Input']
y = df['Output']

# Create a plot
plt.figure(figsize=(8, 6))
plt.plot(x, y, marker='o', linestyle='-', color='b', label='Function')
plt.xlabel('Input')
plt.ylabel('Output')
plt.title('Function Visualization')
plt.legend()

# Display the plot
plt.grid(True)
plt.tight_layout()
plt.show()