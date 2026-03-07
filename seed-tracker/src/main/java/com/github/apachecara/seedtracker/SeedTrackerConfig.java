package com.github.apachecara.seedtracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("seedtracker")
public interface SeedTrackerConfig extends Config
{
	@ConfigSection(
		name = "Seed Lists",
		description = "Configure which seeds to keep or drop",
		position = 0
	)
	String seedListSection = "seedLists";

	@ConfigItem(
		keyName = "keepSeedIds",
		name = "Keep Seed IDs (CSV)",
		description = "Comma-separated item IDs of seeds to KEEP (highlighted green). All other seeds will be highlighted red.",
		section = seedListSection,
		position = 0
	)
	default String keepSeedIds()
	{
		return "";
	}

	@ConfigItem(
		keyName = "highlightOpacity",
		name = "Highlight Opacity",
		description = "Opacity of the inventory highlight (0-255)",
		position = 1
	)
	default int highlightOpacity()
	{
		return 100;
	}
}
