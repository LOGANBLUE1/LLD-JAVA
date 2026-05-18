# LLD-JAVA - Low Level Design Patterns in Java

A comprehensive collection of design patterns and low-level design problems implemented in Java.

## 📋 Table of Contents
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [How to Run](#how-to-run)
- [Design Patterns Included](#design-patterns-included)
- [Design Problems & Games](#design-problems--games)
- [Contributing](#contributing)

## 🏗️ Project Structure

```
LLD-JAVA/
├── src/
│   ├── behaviouralPatterns/
│   │   ├── Chain-of-responsibility/
│   │   ├── Command/
│   │   └── Observer/
│   ├── creationalPatterns/
│   │   ├── AbstractFactory/
│   │   ├── Builder/
│   │   ├── Factory/
│   │   ├── Prototype/
│   │   └── singleton/
│   ├── structuralPatterns/
│   │   ├── Composite/
│   │   ├── Decorator/
│   │   └── Proxy/
│   ├── designProblemsAndGames/
│   │   ├── Parkinglot/
│   │   ├── Restaurant-booking/
│   │   ├── Shapes/
│   │   └── Trello/
│   ├── factory/
│   ├── prototype/
│   └── Main.java
├── out/ (compiled classes)
├── .gitignore
└── README.md
```

## ✅ Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher
  ```bash
  # Check Java version
  java -version
  javac -version
  ```

- **Git**: For cloning the repository
  ```bash
  # Check Git version
  git --version
  ```

- **IDE** (Optional but recommended):
  - IntelliJ IDEA
  - Eclipse
  - VS Code with Java Extension Pack

## 🚀 Getting Started

### Clone the Repository

```bash
# Clone the repository
git clone https://github.com/LOGANBLUE1/LLD-JAVA.git

# Navigate to project directory
cd LLD-JAVA
```

### Verify Project Structure

```bash
# List the source directory
ls -la src/
```

## ▶️ How to Run

### Method 1: Using Command Line

#### 1. Compile the Entire Project

```bash
# Create output directory if it doesn't exist
mkdir -p out

# Compile all Java files
find src -name "*.java" -print0 | xargs -0 javac -d out
```

#### 2. Run Specific Pattern Examples

**Run Main.java:**
```bash
cd out
java Main
```

**Run Observer Pattern:**
```bash
cd out
java behaviouralPatterns.Observer.Main
```

**Run Abstract Factory Pattern:**
```bash
cd out
java creationalPatterns.AbstractFactory.Demo
```

**Run Builder Pattern:**
```bash
cd out
java creationalPatterns.Builder.Main
```

**Run Chain of Responsibility:**
```bash
cd out
java behaviouralPatterns.Chainofresponsibility.Demo
```

**Run Command Pattern:**
```bash
cd out
java behaviouralPatterns.Command.Main
```

**Run Composite Pattern:**
```bash
cd out
java structuralPatterns.Composite.Demo
```

**Run Decorator Pattern:**
```bash
cd out
java structuralPatterns.Decorator.Demo
```

**Run Proxy Pattern:**
```bash
cd out
java structuralPatterns.Proxy.Demo
```

**Run Singleton Pattern:**
```bash
cd out
java creationalPatterns.singleton.DemoSingleThread
java creationalPatterns.singleton.DemoMultiThread
```

**Run Factory Pattern:**
```bash
cd out
java creationalPatterns.Factory.Main
java factory.Demo
```

**Run Prototype Pattern:**
```bash
cd out
java creationalPatterns.Prototype.Main
java prototype.Demo
```

#### 3. Run Design Problems

**Parking Lot System:**
```bash
cd out
java designProblemsAndGames.Parkinglot.Main
```

**Restaurant Booking System:**
```bash
cd out
java designProblemsAndGames.Restaurantbooking.Main
```

**Trello System:**
```bash
cd out
java designProblemsAndGames.Trello.Main
```

**Snake and Ladder Game:**
```bash
cd out
java designProblemsAndGames.Trello.Splitwise.SnakeLadder.Main
```

**Splitwise:**
```bash
cd out
java designProblemsAndGames.Trello.Splitwise.Main
```

### Method 2: Using IntelliJ IDEA

1. **Open Project**
   - Launch IntelliJ IDEA
   - Click `File > Open`
   - Navigate to the `LLD-JAVA` directory and select it
   - Click `OK`

2. **Set up Project SDK**
   - Go to `File > Project Structure > Project`
   - Set the Project SDK to Java 8 or higher
   - Set Language level to match your SDK version
   - Click `Apply` and `OK`

3. **Run Any Main Class**
   - Navigate to any file with a `main` method
   - Right-click on the file
   - Select `Run 'ClassName.main()'`

### Method 3: Using Eclipse

1. **Import Project**
   - Open Eclipse
   - `File > Import > General > Existing Projects into Workspace`
   - Select the `LLD-JAVA` directory
   - Click `Finish`

2. **Run Any Main Class**
   - Navigate to any file with a `main` method
   - Right-click on the file
   - Select `Run As > Java Application`

## 📚 Design Patterns Included

### Behavioral Patterns
- **Chain of Responsibility**: Request handling through a chain of handlers
- **Command**: Encapsulate requests as objects
- **Observer**: Define a one-to-many dependency between objects

### Creational Patterns
- **Abstract Factory**: Create families of related objects
- **Builder**: Construct complex objects step by step
- **Factory**: Create objects without specifying exact classes
- **Prototype**: Clone objects instead of creating new ones
- **Singleton**: Ensure a class has only one instance

### Structural Patterns
- **Composite**: Compose objects into tree structures
- **Decorator**: Add responsibilities to objects dynamically
- **Proxy**: Provide a surrogate or placeholder for another object

## 🎮 Design Problems & Games

### Parking Lot System
A comprehensive parking lot management system with support for:
- Multiple floor management
- Different vehicle types (Car, Bike, Truck)
- Slot allocation and deallocation
- Display available slots

### Restaurant Booking System
A restaurant reservation system featuring:
- Restaurant discovery
- Table booking management
- Time slot management
- Geolocation-based search

### Trello Clone
A task management system implementing:
- Board management
- List management
- Card operations
- User permissions

### Snake and Ladder Game
Classic board game implementation with:
- Dice rolling mechanism
- Snake and ladder logic
- Multiple player support
- Win condition checking

### Splitwise Clone
Expense sharing application with:
- Group expense management
- User balance tracking
- Split calculation
- Expense settlement

## 🛠️ Troubleshooting

### Compilation Errors

If you encounter compilation errors:

1. **Clean and recompile:**
   ```bash
   rm -rf out
   mkdir -p out
   find src -name "*.java" -print0 | xargs -0 javac -d out
   ```

2. **Check Java version:**
   ```bash
   java -version
   javac -version
   ```
   Ensure you're using Java 8 or higher.

3. **Verify package structure:**
   - Package names must match directory structure
   - No spaces or special characters in package names (except dots)

### Common Issues

**Issue: "Cannot find symbol" errors**
- Solution: Make sure all dependencies are compiled and in the classpath

**Issue: "Package does not exist" errors**
- Solution: Ensure package declarations match the directory structure

**Issue: Files not found**
- Solution: Run commands from the correct directory (project root or `out` directory)

## 📝 Notes

- Some design problems may require additional dependencies (like Lombok for annotations)
- Each pattern/problem can be run independently
- The `out` directory contains compiled `.class` files
- Package naming follows camelCase convention (e.g., `behaviouralPatterns`, `creationalPatterns`)

## 🤝 Contributing

Feel free to contribute by:
1. Forking the repository
2. Creating a feature branch
3. Committing your changes
4. Pushing to the branch
5. Creating a Pull Request

## 📄 License

This project is created for educational purposes to demonstrate various design patterns and low-level design implementations in Java.

---

**Happy Coding! 🚀**
