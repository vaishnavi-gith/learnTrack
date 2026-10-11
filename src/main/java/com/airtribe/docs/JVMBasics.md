# JVM, JRE, and JDK Basics

## What is JDK, JRE, and JVM?
- **JDK (Java Development Kit):** The full-featured software development kit required to write, compile, and debug Java programs. It includes the compiler (`javac`) along with the JRE.
- **JRE (Java Runtime Environment):** A software package that provides the minimum requirements (libraries, class loaders, and the JVM) to *execute* an existing Java application. It does not contain development tools like compilers.
- **JVM (Java Virtual Machine):** An abstract computing machine that executes Java bytecode. The JVM is platform-dependent and translates platform-independent bytecode into machine-specific instructions.

## What is Bytecode?
When you compile a Java source file (`.java`) using `javac`, the compiler converts your human-readable code into an intermediate, optimized format called **bytecode** (`.class` files). Bytecode is not machine code; rather, it is a universal instruction set designed to run on any JVM regardless of the underlying operating system.

## Write Once, Run Anywhere (WORA)
The core philosophy of Java is "Write Once, Run Anywhere." Because Java code compiles down to platform-neutral bytecode rather than native machine code, developers only need to write their code once. That exact same bytecode file can then be transported and run on any operating system (Windows, macOS, Linux) as long as that machine has a compatible Java Virtual Machine (JVM) installed to interpret it