package com.weathersettings;

import com.weathersettings.config.Configuration;
import com.weathersettings.event.EventHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class WeatherSettingsMod implements ModInitializer
{
    public static final String        MODID  = "weathersettings";
    public static final Logger        LOGGER = LogManager.getLogger();
    public static       Configuration config = new Configuration();
    public static       Random        rand   = new Random();

    public WeatherSettingsMod()
    {

    }

    @Override
    public void onInitialize()
    {
        ServerTickEvents.END_SERVER_TICK.register(EventHandler::onServerTick);
        ServerLifecycleEvents.SERVER_STARTED.register(EventHandler::onServerStart);
        LOGGER.info(MODID + " mod initialized");
        config.load();
    }
}
