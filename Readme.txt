        ┌───────────────────────┐
        │   User Lands on UI    │
        │  (index.jsp - Home)   │
        └─────────┬─────────────┘
                  │
                  ▼
        ┌──────────────────────────────┐
        │ User Chooses:                │
        │  - Search Room               │
        │  - Book Room                 │
        │  - Cancel Booking            │
        │  - View Booking Details      │
        └──────────┬───────────────────┘
                  ▼
        ┌──────────────────────────────┐
        │ Based on choice:             │
        │ - Go to JSP Form Page        │
        │ - Submit form to Servlet     │
        └──────────┬───────────────────┘
                  ▼
        ┌──────────────────────────────┐
        │ Servlet Receives Request     │
        │ - Extract Parameters         │
        │ - Call OOP Logic             │
        └──────────┬───────────────────┘
                  ▼
        ┌──────────────────────────────┐
        │ BookingManager/Logic Layer   │
        │ - Search / Book / Cancel     │
        │ - Simulate Payment (if any)  │
        └──────────┬───────────────────┘
                  ▼
        ┌──────────────────────────────┐
        │ Store/Read from File/SQLite  │
        └──────────┬───────────────────┘
                  ▼
        ┌──────────────────────────────┐
        │ Response sent back to JSP    │
        │ - Confirmation / Error Page  │
        └──────────────────────────────┘                                   TRIP NEST