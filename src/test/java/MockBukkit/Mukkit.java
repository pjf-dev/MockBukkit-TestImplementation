package MockBukkit;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import dev.heyitsskay.mockbukkittestimplementation.MockBukkitTestImplementation;
import org.bukkit.GameMode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Mukkit {

    private ServerMock server;
    private MockBukkitTestImplementation plugin;

    @Before
    public void setUp()
    {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(MockBukkitTestImplementation.class);
    }

    @Test
    public void testGMCCommand() {
        PlayerMock p = server.addPlayer();
        p.setGameMode(GameMode.ADVENTURE);
        p.performCommand("gmc");
        p.assertGameMode(GameMode.CREATIVE);
    }

    @Test
    public void testGMSCommand() {
        PlayerMock p = server.addPlayer();
        p.setGameMode(GameMode.ADVENTURE);
        p.performCommand("gms");
        p.assertGameMode(GameMode.SURVIVAL);
    }

    @After
    public void tearDown()
    {
        MockBukkit.unmock();
    }

}
