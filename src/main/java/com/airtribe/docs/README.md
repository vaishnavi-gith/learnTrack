# LearnTrack - Student & Course Management System

LearnTrack is a console-based Student & Course Management System built using **Core Java**. It allows administrators to manage students, courses, and student enrollments efficiently while demonstrating robust Object-Oriented Programming (OOP) principles and clean architecture.

## Features
- **Student Management**: Add, view, search by ID, and deactivate students.
- **Course Management**: Add, view, and toggle the status of courses.
- **Enrollment Management**: Enroll students in courses, view a student's active enrollments, and update statuses.
- **Robust Error Handling**: Custom `EntityNotFoundException` and input mismatch checks to prevent application crashes.

---
# Project Design Notes

## Why ArrayList instead of a standard Array?
Standard Java arrays have a fixed size defined at the time of creation, which makes handling dynamic collections (like an expanding list of students or courses added by an admin at runtime) very rigid and prone to size limits. We used `ArrayList` because it dynamically resizes itself automatically as items are added or removed, offering built-in utility methods like `add()`, `get()`, and `size()` that make managing memory and data much cleaner.

## Where and Why We Used Static Members
We utilized `static` members inside the `IdGenerator` utility class (e.g., `private static int studentIdCounter`).
- **Why:** A static field belongs to the class itself rather than individual instances. This ensures that the ID counter state is shared globally across the application, guaranteeing that every newly created student or course receives a unique, sequentially incremented ID regardless of which service created it.

## Where and Why We Used Inheritance
We introduced a base class `Person` and extended it to create `Student`.
- **Why:** Both `Student` (and potential future roles like `Trainer`) share common identification fields such as `id`, `firstName`, `lastName`, and `email`. By moving these into a parent `Person` class, we practiced code reusability and clean design. Additionally, we used method overriding with `getDisplayName()` to demonstrate polymorphism, allowing specialized classes to modify or extend behaviors cleanly.


## How to Compile and Run

### Using an IDE (IntelliJ IDEA / Eclipse)
1. Open the project folder in your IDE.
2. Navigate to `src/com/airtribe/Main.java`.
3. Right-click and select **Run 'Main.main()'**.

### Using the Terminal
1. Open your terminal and navigate to the `src` directory:
   ```bash
   cd src