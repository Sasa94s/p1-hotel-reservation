# Hotel Reservation

Java Console application will allow customers to find and book a hotel room based on room availability. This project demonstrates design classes using OOP, organize and process data with collections, and use common Java types.

## Dependencies
- Java v17+
- IDE (e.g. InelliJ IDEA)

## Getting Started
- Navigate to `com.melsheikh.hotelreservation.main.HotelApplication` class
- Run `main` method

## Best Practices Applied
To ensure clean and highly maintainable code, Design Patterns applied such as:
- Dependency Injection
- Inversion of Control
- Repository

## Features

### User Features
- **Customer Account Creation:** Users can create a customer account, which is a prerequisite for making any room reservations.
- **Room Search:** The application enables users to search for available rooms within a specified date range, displaying a list of options when available rooms are found.
- **Room Booking:** Users can book their chosen room, creating a reservation for their stay.
- **Reservation Viewing:** Customers have the ability to view all their reservations, providing a comprehensive overview of their booking history.

### Administrative Features
- **Customer Overview:** Administrators can view all customer accounts, keeping track of the app’s user base.
- **Room Management:** Administrators have access to a complete list of rooms in the hotel and can add new rooms, facilitating room inventory management.
- **Reservation Management:** Viewing all hotel reservations is streamlined, allowing administrators to monitor booking activities.
- **Room Addition:** Administrators can add rooms to the hotel’s offerings, enhancing the hotel’s capacity and guest options.

### Reservation Logic
- **Conflict-Free Bookings:** The app ensures that each room is booked by only one customer for any given date range, preventing double bookings.
- **Recommended Alternatives:** If no rooms are available for the desired dates, the system suggests alternative dates by searching for availability seven days beyond the original range, offering flexibility to the customers.

### Room Specifics
- **Pricing Display:** Room costs per night are clearly displayed, distinguishing between paid and complimentary (free) rooms.
- **Unique Identifiers:** Every room is assigned a unique number, ensuring easy identification and booking.
- **Room Types:** The app categorizes rooms into single or double occupancy, catering to different guest needs.

### Customer Account Details
- **Unique Email Requirement:** Each customer account is identified by a unique email address, validated through a simple RegEx pattern to match the format name@domain.com.
- **Personal Information:** Accounts capture essential information, including the customer's first name and last name.

### Error Handling
- **Robust and User-Friendly:** The application is designed to handle exceptions gracefully, ensuring the app remains stable and informative during unexpected input scenarios or operational hiccups. 

### Testing and Validation
- **Comprehensive Testing:** The application has been thoroughly tested to ensure functionality, including the ability to find rooms based on various dates and to handle fully booked scenarios by providing alternative recommendations.
