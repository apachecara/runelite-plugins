package com.github.apachecara.seedtracker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Seed Tracker",
	description = "Highlights seeds in inventory as green (keep) or red (drop) based on a configurable CSV of item IDs",
	tags = {"seed", "farming", "inventory", "highlight", "uim"}
)
public class SeedTrackerPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SeedTrackerOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		log.debug("Seed Tracker started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		log.debug("Seed Tracker stopped!");
	}

	@Provides
	SeedTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SeedTrackerConfig.class);
	}
}
