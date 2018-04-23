package fr.univ_smb.isc.m2.integration_tests.clan;
import fr.univ_smb.isc.m2.domain.clan.ClanService;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClanServiceUnitTest {
    @Test
    public void should_SelectById_On_clanService(){
        ClanService clan = new ClanService();
        assertThat(clan.selectById(1).getId() == 1).isEqualTo(true);
    }

    /*
    @Test
    public void should_create_On_clanService(){
        ClanService clan = new ClanService();
        clan.create("testName","testLocalisation",0);
        assertThat(clan.selectById(3).getName().equals("testName")).isEqualTo(true);
    }
*/
    @Test
    public void should_delete_On_clanService(){
        ClanService clan = new ClanService();
        clan.delete(2);
        assertThat(clan.selectById(2) == null).isEqualTo(true);
    }
/*
    @Test
    public void should_modifie_On_clanService(){
        ClanService clan = new ClanService();
        clan.modifie(1,0);
        assertThat(clan.selectById(1).getFound() == 0).isEqualTo(true);
    }
    */
}

