package validators.Impl;

import domain.Client;
import exceptions.BusinessException;
import services.ClientService;
import services.OrderService;
import services.ProductService;
import validators.ValidationService;

import java.util.ArrayList;
import java.util.List;

public class ValidationServiceImpl implements ValidationService {
    private final ClientService clientService;
    private final OrderService orderService;
    private final ProductService productService;

    public ValidationServiceImpl(ClientService clientService, OrderService orderService, ProductService productService) {
        this.clientService = clientService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public void validateAge(int age) throws BusinessException {
        if (age < 0 || age > 200) {
            System.out.println("Age can't be less than 0 and more than 200!");
            throw new BusinessException("Incorrect age!");
        }
    }

    @Override
    public void validatePhone(String phone) throws BusinessException {
        String phoneRegexp = "(067|063|095)-\\d{3}-\\d{2}-\\d{2}";
        if (!phone.matches(phoneRegexp)) {
            System.out.println("Please use next format XXX-XXX-XX-XX where X is digit.");
            System.out.println("Only 067, 063, 095 operators are supported.");
            throw new BusinessException("Incorrect phone!");
        }
        List<Client> phones = clientService.getAllClients();
        for (Client client : phones) {
            if (client.getPhone().equals(phone)) {
                System.out.println(String.format("Client with id %d is the same with your input. " +
                        "Please type different phone.", client.getId()));
                throw new BusinessException("Phone number already exists!");

            }
        }
    }

    @Override
    public void validateEmail(String email) throws BusinessException {
        String emailRegexp = "^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        if (!email.matches(emailRegexp)) {
            System.out.println("You made one of mistakes listed below:\n" +
                    "example – No @ symbole\n" +
                    "example@.com.my – Dot after @ symbol\n" +
                    "example123@gmail.a – last TLD length is less than 2\n" +
                    "example123@@.com.com – Two @ symbols\n" +
                    ".example@journaldev.com – ID can’t start with .\n" +
                    "example()*@gmail.com – invalid special characters in the ID\n" +
                    "example@%*.com – invalid special characters in the TLD\n" +
                    "example..2002@gmail.com – ID can’t have two dots\n" +
                    "example.@gmail.com – ID can’t end with dot\n" +
                    "example@journaldev@gmail.com – Two @ symbols\n" +
                    "example@gmail.com.1a – last TLD can have characters only");
            throw new BusinessException("Incorrect email!");
        }
    }
}
