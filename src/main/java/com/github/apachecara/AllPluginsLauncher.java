package com.github.apachecara;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

import com.github.apachecara.seedtracker.SeedTrackerPlugin;
import com.github.apachecara.contracttooltip.ContractTooltipPlugin;

/**
 * Launches RuneLite with ALL plugins loaded.
 * Add new plugin classes here as you create them.
 */
public class AllPluginsLauncher
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(
			SeedTrackerPlugin.class,
			ContractTooltipPlugin.class
		);
		RuneLite.main(args);
	}
}
