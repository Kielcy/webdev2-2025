# Car Management Frontend

A modern, responsive frontend application for managing cars using JavaScript and Tailwind CSS.

## Project Structure

```
Frontend/
├── index.html          # Main HTML file with Tailwind CSS
├── js/
│   └── script.js      # JavaScript application logic
└── README.md          # This file
```

## Features

- ✅ **Complete CRUD Operations**: Create, Read, Update, Delete cars
- ✅ **Modern UI**: Beautiful interface with Tailwind CSS
- ✅ **Responsive Design**: Works on desktop, tablet, and mobile
- ✅ **Real-time Updates**: Instant UI updates after operations
- ✅ **Error Handling**: User-friendly error messages
- ✅ **Loading States**: Visual feedback during API calls
- ✅ **Confirmation Dialogs**: Safe delete operations
- ✅ **Form Validation**: Client-side validation

## Setup Instructions

### 1. Start Your Spring Boot API
Make sure your Spring Boot application is running on `http://localhost:8080`

### 2. Open the Frontend
Navigate to the `Frontend` folder and open `index.html` in your web browser. No build process required!

### 3. API Configuration
The frontend is configured to connect to your Spring Boot API at:
```
http://localhost:8080/api
```

If your API runs on a different port, update the `API_BASE_URL` in `js/script.js`:
```javascript
const API_BASE_URL = 'http://localhost:YOUR_PORT/api';
```

## How to Use

1. **View Cars**: All cars are displayed in a responsive grid
2. **Add Car**: Click "Add New Car" button to create a new car
3. **Edit Car**: Click the edit icon (pencil) on any car card
4. **Delete Car**: Click the delete icon (trash) and confirm deletion
5. **Form Validation**: All fields are required and validated

## API Endpoints Used

- `GET /api/cars` - Fetch all cars
- `POST /api/cars` - Create new car
- `PUT /api/cars/{id}` - Update existing car
- `DELETE /api/cars/{id}` - Delete car

## Technologies Used

- **HTML5**: Semantic markup
- **Tailwind CSS**: Utility-first CSS framework (via CDN)
- **Vanilla JavaScript**: No frameworks, pure JS
- **Font Awesome**: Icons (via CDN)
- **Fetch API**: HTTP requests

## Browser Compatibility

- Chrome (recommended)
- Firefox
- Safari
- Edge

## Troubleshooting

### API Connection Issues
- Ensure your Spring Boot server is running
- Check the API_BASE_URL in `js/script.js` matches your server
- Verify CORS is enabled in your Spring Boot app

### CORS Issues
If you encounter CORS errors, make sure your Spring Boot `CarController` has:
```java
@CrossOrigin
@RestController
@RequestMapping("/api")
```

## Customization

### Styling
All styles use Tailwind CSS classes. You can easily customize:
- Colors: Change `bg-blue-600` to your preferred color
- Spacing: Modify padding/margin classes
- Layout: Adjust grid columns and responsive breakpoints

### API Integration
The `CarManager` class handles all API communication. You can extend it to:
- Add more car properties
- Implement search/filtering
- Add pagination
- Include image uploads

## File Organization

- **`index.html`**: Main application file with embedded Tailwind CSS
- **`js/script.js`**: All JavaScript logic organized in a CarManager class
- **`README.md`**: Documentation and setup instructions

This structure keeps your frontend code organized and maintainable while being easy to deploy and use.
