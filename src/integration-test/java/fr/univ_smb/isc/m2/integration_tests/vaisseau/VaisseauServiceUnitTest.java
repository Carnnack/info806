package fr.univ_smb.isc.m2.integration_tests.vaisseau;
        import fr.univ_smb.isc.m2.domain.vaisseau.VaisseauService;
        import org.junit.Test;

        import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class VaisseauServiceUnitTest {
    @Test
    public void should_SelectById_On_vaisseauService(){
        VaisseauService vaisseau = new VaisseauService();
        assertThat(vaisseau.selectById(1).getId() == 1).isEqualTo(true);
    }

    @Test
    public void should_create_On_vaisseauService(){
        VaisseauService vaisseau = new VaisseauService();
        vaisseau.create("testName","testType",0,0,0);
        assertThat(vaisseau.selectById(6).getName().equals("testName")).isEqualTo(true);
    }

    @Test
    public void should_delete_On_vaisseauService(){
        VaisseauService vaisseau = new VaisseauService();
        vaisseau.delete(4);
        assertThat(vaisseau.selectById(4) == null).isEqualTo(true);
    }

    @Test
    public void should_modifie_On_vaisseauService(){
        VaisseauService vaisseau = new VaisseauService();
        vaisseau.modifie(3,"testCapitain");
        assertThat(vaisseau.selectById(3).getNomCapitaine().equals("testCapitain")).isEqualTo(true);
    }
}