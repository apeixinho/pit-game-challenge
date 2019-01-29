package game.pit.model;

import game.pit.service.PitGameService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PitGameTest {

    @Mock
    private PitGameService pitGameService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetGame() throws Exception {

        int[][] testGame = new int[][]{{6, 6, 6, 6, 6, 6, 0}, {6, 6, 6, 6, 6, 6, 0}};

        when(pitGameService.getGame()).thenReturn(testGame);
        mockMvc.perform(MockMvcRequestBuilders.get("/game"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void testGetGameStateForPlayer1() throws Exception {

        int[] testGetGameStatePlayer = new int[]{6, 6, 6, 6, 6, 6, 0};

        when(pitGameService.getPlayer1GameState()).thenReturn(testGetGameStatePlayer);
        mockMvc.perform(MockMvcRequestBuilders.get("/gamestate/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }


}
