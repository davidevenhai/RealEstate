import java.util.Scanner;

public class RealEstate {

    private User[] users = new User[5];
    private Property[] properties;
    private City[] cities;
    private final int FIRST_NUMBER = 0, SECOND_NUMBER = 1, PHONE_LENGTH = 10, MIN_PASS_LENGTH = 5;


    public RealEstate() {
        this.cities = new City[10];
        City yeruham = new City("Yeruham", "Negev", "Rabin, Begin");
        City dimona = new City("Dimona", "Negev", "Kadesh, Ben ami");
        City ashkelon = new City("Ashkelon", "South", "Carmel, Binyamin");
        City ashdod = new City("Ashdod", "South", "Habanot, Yekutiel adam");
        City telAviv = new City("Tel Aviv", "Central", "Jerusalem,Bet ezra");
        City rishonLezion = new City("Rishon Lezion", "Central", "Golani, Alexandroni");
        City netanya = new City("Netanya", "Sharon", "Givati, Yaalom");
        City herzliya = new City("Herzliya", "Sharon", "Nahal, City");
        City nahariya = new City("Nahariya", "North", "Bar kochva, Balfor");
        City carmiel = new City("Carmiel", "North", "Paratroops, Navon");
        this.cities = new City[]{yeruham, dimona, ashkelon, ashdod, telAviv, rishonLezion, netanya, herzliya, nahariya, carmiel};
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please enter 1 - to create a new user\nPlease enter 2 - to log in\nPlease enter 3 to quit the program");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createUser();
                case 2 -> {
                    User user = login();
                    if (user == null) {
                        System.out.println("The user doesn't exists in the system");
                    } else {
                        menuProperty(user);
                    }
                }
                case 3 -> endProgram();
            }
            if (choice == 3) break;
        } while (choice != 1 && choice != 2);
    }

    public void endProgram() {
        System.out.println("Bye.");
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your user name");
        String userName = scanner.nextLine();
        User user = null;
        boolean currectUser = false;
        int userLocation = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(userName)) {
                userLocation = i;
                currectUser = true;
                break;
            }
        }
        boolean isCurrectPassword = false;
        if (currectUser) {
            System.out.println("Please enter your password");
            String password = scanner.nextLine();
            if (users[userLocation].getPassword().equals(password)) ;
            {
                isCurrectPassword = true;
                user = users[userLocation];
            }
        }
        return user;
    }


    public void createUser() {
        User[] usersArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            usersArray[i] = this.users[i];
        }
        User newUser = new User(userId(), password(), phoneNumber(), isRealEstateAgent());
        usersArray[this.users.length] = newUser;
        this.users = usersArray;
    }


    private String userId() {
        Scanner scanner = new Scanner(System.in);
        String userId;
        boolean checkName = false;
        do {
            System.out.println("Please enter your user name");
            userId = scanner.nextLine();
            checkName = isIdExists(userId);
            if (checkName) {
                System.out.println("The user name is already in the system");
            }
        } while (checkName);
        return userId;
    }

    private boolean isIdExists(String userId) {
        boolean isExist = false;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] != null) {
                if (this.users[i].getName().equals(userId)) {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    private boolean isRealEstateAgent() {
        Scanner scanner = new Scanner(System.in);
        boolean isRealEstate = false;
        int answer;
        do {
            System.out.println("Please enter 1 if you are a real estate agent, 2 if regular user");
            answer = scanner.nextInt();
        } while (answer != 1 && answer != 2);
        if (answer == 1) {
            isRealEstate = true;
        }
        return isRealEstate;
    }

    private String password() {
        Scanner scanner = new Scanner(System.in);
        String password;
        do {
            System.out.println("Please enter a valid password that contains at least 5 characters and has at least one of those symbols : ($,%,_)");
            password = scanner.nextLine();
            if (!checkPass(password)) {
                System.out.println("You entered invalid password");
            }
        } while (!checkPass(password));
        return password;
    }


    private boolean checkPass(String password) {
        boolean check = false;
        if (password.length() >= 5) {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == '_' || password.charAt(j) == '$' || password.charAt(j) == '%') {
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    private String phoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        do {
            System.out.println("Please enter a valid Israeli phone number");
            phoneNumber = scanner.nextLine();
        } while (!isValidPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        boolean isValid = false;
        if (phoneNumber.charAt(FIRST_NUMBER) == '0' && phoneNumber.charAt(SECOND_NUMBER) == '5' && phoneNumber.length() == PHONE_LENGTH) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                char tempChar = phoneNumber.charAt(i);
                if (!Character.isDigit(tempChar)) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
        }
        if (!isValid) {
            System.out.println("You entered invalid phone number");
        }
        return isValid;
    }

    public void menuProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can continue to choose from the following list:");
        System.out.println("1.Post a new property.");
        System.out.println("2.Remove advertising on a property.");
        System.out.println("3.show all the properties in the system.");
        System.out.println("4.View all my properties.");
        System.out.println("5.Search for a property by parameter.");
        System.out.println("6.Disconnect and return to the main menu.");
        int newChoice;
        do {
            newChoice = scanner.nextInt();
            switch (newChoice) {
                case 1 -> {
                    if (postNewProperty(user)) {
                        System.out.println("Your property is saved");
                    } else System.out.println("Your property has not been saved");
                }
                case 2 -> removeProperty(user);
                case 3 -> printAllProperties();
                case 4 -> printProperties(user);
                case 5 -> search();
                case 6 -> System.out.println("Your are log out.");
            }
        } while (newChoice < 1 && newChoice > 6);
    }


    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean checkAllowPost;
        int counter = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getSellerName() == user)
                counter++;
        }
        if (user.isRealEstateAgentOrRegular() && counter < 5) {
            checkAllowPost = true;
            System.out.println("You can post,Note that you can post" + (5 - counter) + " more");
        } else if (!user.isRealEstateAgentOrRegular() && counter < 2) {
            checkAllowPost = true;
            System.out.println("You can post,Note that you can post" + (2 - counter) + " more");
        } else {
            checkAllowPost = false;
            System.out.println("You cannot post, you have reached a maximum number");
        }
        if (checkAllowPost) {
            int city = checkCity();
            if (city == -1) {
                System.out.println("The name of the city does not exist in the system");
            } else {
                boolean currectStreet = checkStreets(city);
                if (!currectStreet) {
                    System.out.println("The street you gave is not on the available streets");
                } else {

                }

                }
            }

        }

    }

    public int checkCity() {
        Scanner scanner = new Scanner(System.in);
        boolean checkCity = false;
        for (int i = 0; i < this.cities.length; i++) {
            System.out.println(this.cities[i].getName() + " , ");
        }
        System.out.println("Please enter the name of the city you would like to see");
        String nameCity = scanner.nextLine();
        nameCity = nameCity.toLowerCase();
        int location = -1;
        for (int t = 0; t < this.cities.length; t++) {
            if (this.cities[t].getName().toLowerCase().equals(nameCity)) {
                checkCity = true;
                location = t;
                break;
            }
        }
        return location;

    }

    public boolean checkStreets(int city) {
        Scanner scanner = new Scanner(System.in);
        boolean checkStreet = false;
        System.out.println(this.cities[city].getAvailableStreets());
        System.out.println("Please enter a street");
        String nameStreet = scanner.nextLine();
        nameStreet = nameStreet.toLowerCase();
        String[] parts = this.cities[city].getAvailableStreets().split(", ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].toLowerCase().equals(nameStreet)) {
                checkStreet = true;
                break;
            }
        }
        return checkStreet;
    }
    public void propertyType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for normal apartment in the building\n" +
                "Press 2 for Penthouse in the building\n" +
                "Press 3 for a private house");
        int userChoice = scanner.nextInt();
        boolean validCheck = false;
        if (userChoice >= 1 && userChoice <= 3) {
            validCheck = true;
            switch (userChoice) {
                case 1 -> buildingApartment(this.cities[]);
            }else{
                //return valid check = false
            }
        }
    }
    public boolean buildingApartment(int city) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("What floor is the property on?");
        int floor = scanner.nextInt();
        System.out.println("How many rooms are in the property?");
        int room = scanner.nextInt();
        System.out.println("What is the property's house number?");
        int homeNumber = scanner.nextInt();
        boolean rentOrSale = false;
        int rentOrSaleInt;
        do {
            System.out.println("Press 1 if the building is for rent\t" +
                    "press 2 if the building is for sale");
            rentOrSaleInt = scanner.nextInt();
            if(rentOrSaleInt == 1) {
                rentOrSale = true;
            }if(rentOrSaleInt == 2) {
                rentOrSale = false;
            }
        } while (rentOrSaleInt!=1 && rentOrSaleInt!=2);
        System.out.println("What is the price for the property?");
        int price = scanner.nextInt();
        Property property1 = new Property(this.cities[city], nameStreet, room, price, "normal apartment", checkRent, homeNumber, floor, user);
        for (int j = 0; j < this.properties.length; j++) {
            if (properties[j] == null) {
                properties[j] = propery1;
                break;
            }
        }
    }
}

}

