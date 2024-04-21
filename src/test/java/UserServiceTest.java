import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.stubbing.OngoingStubbing;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Mock

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour la méthode creerUtilisateur
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'appel à l'API
        verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
    }
    //Exercice 3 question 1

    @Test
    public void testCreerUtilisateur_EchecCreation() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour lever une exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock)
                .creerUtilisateur(any(Utilisateur.class));
    }
 // Execercice 3 q2
 @Test
 public void testCreerUtilisateur_ErrorValidation() throws ServiceException {
     // Préparation des données d'utilisateur invalides
     Utilisateur utilisateurInvalid = new Utilisateur(null, null, null);

     // Appel de la méthode à tester avec des données invalides
     userService.creerUtilisateur(utilisateurInvalid);

     // Vérification que la méthode utilisateurApiMock.creerUtilisateur n'est jamais appelée
     verify(utilisateurApiMock, never()).creerUtilisateur(utilisateurInvalid);
 }
 @Test
    public void testCreerUtilisateur_AvecId() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Définition d'un ID fictif
        int idUtilisateur = 123;

        // Configuration du comportement du mock pour renvoyer l'ID
    //when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(Integer.valueOf(idUtilisateur));


     // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        assertEquals(idUtilisateur, utilisateur.getId());
    }


}













