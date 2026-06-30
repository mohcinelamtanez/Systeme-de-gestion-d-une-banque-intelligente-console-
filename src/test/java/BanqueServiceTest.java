import com.mycompany.banque.factory.ClientFactory;
import com.mycompany.banque.ui.Banque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.banque.entity.* ;
import com.mycompany.banque.service.* ;


/**
 * @author USER
 **/
public class BanqueServiceTest {

    ServiceBancaire banqueService = new ServiceBancaire() ;
    Client client = ClientFactory.createStandardClient();
    @Test
    public void shouldAddClientSuccessfully() {

    }

    @Test
    void shouldThrowException() {
        assertThrows(
                RuntimeException.class,
                () -> banqueService.ajouterClient(client)
        );
    }
}
