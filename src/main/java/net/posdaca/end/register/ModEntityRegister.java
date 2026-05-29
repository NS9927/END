package net.posdaca.end.register;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.neoforged.bus.api.IEventBus;
import net.posdaca.end.entity.modZombie.ModZombieEntity;

public class ModEntityRegister {
    public static void register(IEventBus modEventBus) {
        CreateRegistrate registrate = ModRegistrate.REGISTRATE;
        registrate.registerEventListeners(modEventBus);

        ModZombieEntity.registerEntities(registrate);
    }
}
