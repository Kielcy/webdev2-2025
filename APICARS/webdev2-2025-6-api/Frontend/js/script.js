// API Configuration
const API_BASE_URL = 'http://localhost:8080/api';

// Car Management Class
class CarManager {
    constructor() {
        this.cars = [];
        this.currentCarId = null;
        this.isEditMode = false;
        this.init();
    }

    init() {
        this.bindEvents();
        this.loadCars();
    }

    bindEvents() {
        // Modal controls
        document.getElementById('addCarBtn').addEventListener('click', () => this.showAddModal());
        document.getElementById('addFirstCarBtn').addEventListener('click', () => this.showAddModal());
        document.getElementById('closeModal').addEventListener('click', () => this.hideModal());
        document.getElementById('cancelBtn').addEventListener('click', () => this.hideModal());
        
        // Form submission
        document.getElementById('carForm').addEventListener('submit', (e) => this.handleFormSubmit(e));
        
        // Delete modal controls
        document.getElementById('cancelDeleteBtn').addEventListener('click', () => this.hideDeleteModal());
        document.getElementById('confirmDeleteBtn').addEventListener('click', () => this.confirmDelete());
        
        // Close modals when clicking outside
        document.getElementById('carModal').addEventListener('click', (e) => {
            if (e.target.id === 'carModal') this.hideModal();
        });
        document.getElementById('deleteModal').addEventListener('click', (e) => {
            if (e.target.id === 'deleteModal') this.hideDeleteModal();
        });
    }

    // API Methods
    async fetchCars() {
        try {
            const response = await fetch(`${API_BASE_URL}/cars`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error fetching cars:', error);
            throw error;
        }
    }

    async createCar(carData) {
        try {
            const response = await fetch(`${API_BASE_URL}/cars`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(carData)
            });
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            return await response.json();
        } catch (error) {
            console.error('Error creating car:', error);
            throw error;
        }
    }

    async updateCar(id, carData) {
        try {
            const response = await fetch(`${API_BASE_URL}/cars/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(carData)
            });
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            return await response.json();
        } catch (error) {
            console.error('Error updating car:', error);
            throw error;
        }
    }

    async deleteCar(id) {
        try {
            const response = await fetch(`${API_BASE_URL}/cars/${id}`, {
                method: 'DELETE'
            });
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
        } catch (error) {
            console.error('Error deleting car:', error);
            throw error;
        }
    }

    // UI Methods
    async loadCars() {
        this.showLoading(true);
        this.hideMessages();
        
        try {
            this.cars = await this.fetchCars();
            this.renderCars();
        } catch (error) {
            this.showError('Failed to load cars. Please check if the API server is running.');
            this.showEmptyState();
        } finally {
            this.showLoading(false);
        }
    }

    renderCars() {
        const carsGrid = document.getElementById('carsGrid');
        const emptyState = document.getElementById('emptyState');
        
        if (this.cars.length === 0) {
            carsGrid.classList.add('hidden');
            emptyState.classList.remove('hidden');
            return;
        }
        
        emptyState.classList.add('hidden');
        carsGrid.classList.remove('hidden');
        
        carsGrid.innerHTML = this.cars.map(car => this.createCarCard(car)).join('');
    }

    createCarCard(car) {
        return `
            <div class="bg-white rounded-lg shadow-md hover:shadow-lg transition duration-200 overflow-hidden">
                <div class="p-6">
                    <div class="flex justify-between items-start mb-4">
                        <div>
                            <h3 class="text-xl font-semibold text-gray-800">${car.make} ${car.model}</h3>
                            <p class="text-gray-600">${car.year}</p>
                        </div>
                        <div class="flex space-x-2">
                            <button onclick="carManager.showEditModal(${car.id})" 
                                    class="text-blue-500 hover:text-blue-700 transition duration-200"
                                    title="Edit car">
                                <i class="fas fa-edit"></i>
                            </button>
                            <button onclick="carManager.showDeleteModal(${car.id}, '${car.make} ${car.model}')" 
                                    class="text-red-500 hover:text-red-700 transition duration-200"
                                    title="Delete car">
                                <i class="fas fa-trash"></i>
                            </button>
                        </div>
                    </div>
                    
                    <div class="space-y-2">
                        <div class="flex items-center text-gray-600">
                            <i class="fas fa-palette w-4 mr-2"></i>
                            <span>Color: ${car.color}</span>
                        </div>
                        <div class="flex items-center text-gray-600">
                            <i class="fas fa-calendar w-4 mr-2"></i>
                            <span>Year: ${car.year}</span>
                        </div>
                    </div>
                </div>
            </div>
        `;
    }

    showAddModal() {
        this.isEditMode = false;
        this.currentCarId = null;
        document.getElementById('modalTitle').textContent = 'Add New Car';
        document.getElementById('saveBtn').textContent = 'Save Car';
        this.clearForm();
        this.showModal();
    }

    showEditModal(carId) {
        this.isEditMode = true;
        this.currentCarId = carId;
        const car = this.cars.find(c => c.id === carId);
        
        if (car) {
            document.getElementById('modalTitle').textContent = 'Edit Car';
            document.getElementById('saveBtn').textContent = 'Update Car';
            this.populateForm(car);
            this.showModal();
        }
    }

    showModal() {
        document.getElementById('carModal').classList.remove('hidden');
        document.body.style.overflow = 'hidden';
    }

    hideModal() {
        document.getElementById('carModal').classList.add('hidden');
        document.body.style.overflow = 'auto';
        this.clearForm();
    }

    showDeleteModal(carId, carName) {
        this.currentCarId = carId;
        document.getElementById('carToDelete').textContent = carName;
        document.getElementById('deleteModal').classList.remove('hidden');
        document.body.style.overflow = 'hidden';
    }

    hideDeleteModal() {
        document.getElementById('deleteModal').classList.add('hidden');
        document.body.style.overflow = 'auto';
        this.currentCarId = null;
    }

    clearForm() {
        document.getElementById('carForm').reset();
    }

    populateForm(car) {
        document.getElementById('make').value = car.make;
        document.getElementById('model').value = car.model;
        document.getElementById('year').value = car.year;
        document.getElementById('color').value = car.color;
    }

    async handleFormSubmit(e) {
        e.preventDefault();
        
        const formData = new FormData(e.target);
        const carData = {
            make: formData.get('make'),
            model: formData.get('model'),
            year: parseInt(formData.get('year')),
            color: formData.get('color')
        };

        try {
            if (this.isEditMode) {
                await this.updateCar(this.currentCarId, carData);
                this.showSuccess('Car updated successfully!');
            } else {
                await this.createCar(carData);
                this.showSuccess('Car added successfully!');
            }
            
            this.hideModal();
            await this.loadCars();
        } catch (error) {
            this.showError('Failed to save car. Please try again.');
        }
    }

    async confirmDelete() {
        try {
            await this.deleteCar(this.currentCarId);
            this.showSuccess('Car deleted successfully!');
            this.hideDeleteModal();
            await this.loadCars();
        } catch (error) {
            this.showError('Failed to delete car. Please try again.');
        }
    }

    showLoading(show) {
        const spinner = document.getElementById('loadingSpinner');
        if (show) {
            spinner.classList.remove('hidden');
        } else {
            spinner.classList.add('hidden');
        }
    }

    showError(message) {
        const errorDiv = document.getElementById('errorMessage');
        const errorText = document.getElementById('errorText');
        errorText.textContent = message;
        errorDiv.classList.remove('hidden');
        
        // Auto-hide after 5 seconds
        setTimeout(() => {
            errorDiv.classList.add('hidden');
        }, 5000);
    }

    showSuccess(message) {
        const successDiv = document.getElementById('successMessage');
        const successText = document.getElementById('successText');
        successText.textContent = message;
        successDiv.classList.remove('hidden');
        
        // Auto-hide after 3 seconds
        setTimeout(() => {
            successDiv.classList.add('hidden');
        }, 3000);
    }

    hideMessages() {
        document.getElementById('errorMessage').classList.add('hidden');
        document.getElementById('successMessage').classList.add('hidden');
    }

    showEmptyState() {
        document.getElementById('carsGrid').classList.add('hidden');
        document.getElementById('emptyState').classList.remove('hidden');
    }
}

// Initialize the application when the page loads
let carManager;
document.addEventListener('DOMContentLoaded', () => {
    carManager = new CarManager();
});
