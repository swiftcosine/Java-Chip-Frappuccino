/*
 * Class: CMSC203
 * Instructor: Prof. Tarek
 * Description: Prompt the user for the patient's information including name, address, and emergency contact details, displays information about three procedures, and the total charges of the procedures
 * Due: October 1, 2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Ash Ibasan
 */
package patientinfo;

public class Patient {
    private String firstName, middleName, lastName, address, city, state, zip, phone, emergencyName, emergencyPhone;
    
        // No-arg constructor
        public Patient() {}

        // Constructor with name fields only
        public Patient(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        // Full constructor for all fields
        public Patient(String firstName, String middleName, String lastName, String address,
                       String city, String state, String zip, String phone,
                       String emergencyName, String emergencyPhone) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
            this.emergencyName = emergencyName;
            this.emergencyPhone = emergencyPhone;
        }

        // Accessors (getters)
        public String getFirstName() { return firstName; }
        public String getMiddleName() { return middleName; }
        public String getLastName() { return lastName; }
        public String getAddress() { return address; }
        public String getCity() { return city; }
        public String getState() { return state; }
        public String getZip() { return zip; }
        public String getPhone() { return phone; }
        public String getEmergencyName() { return emergencyName; }
        public String getEmergencyPhone() { return emergencyPhone; }

        // Mutators (setters)
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setMiddleName(String middleName) { this.middleName = middleName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setAddress(String address) { this.address = address; }
        public void setCity(String city) { this.city = city; }
        public void setState(String state) { this.state = state; }
        public void setZip(String zip) { this.zip = zip; }
        public void setPhone(String phone) { this.phone = phone; }
        public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }
        public void setEmergencyPhone(String emergencyPhone) { this.emergencyPhone = emergencyPhone; }

        // Build full name
        public String buildFullName() {
            return firstName + " " + middleName + " " + lastName;
        }

        // Build address
        public String buildAddress() {
            return address + " " + city + " " + state + " " + zip;
        }

        // Build emergency contact
        public String buildEmergencyContact() {
            return emergencyName + " " + emergencyPhone;
        }

        // toString method using build methods
        @Override
        public String toString() {
            return "Name: " + buildFullName() + "\n" +
                   "Address: " + buildAddress() + "\n" +
                   "Phone: " + phone + "\n" +
                   "Emergency Contact: " + buildEmergencyContact();
        }
    }

