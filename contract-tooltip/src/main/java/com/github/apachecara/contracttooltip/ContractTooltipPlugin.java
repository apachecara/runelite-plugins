package com.github.apachecara.contracttooltip;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Contract Tooltip",
	description = "Shows farming contract info on seed hover: contract tier, quantity needed, and assignment probability",
	tags = {"farming", "contract", "seed", "tooltip", "ironman", "uim"}
)
public class ContractTooltipPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ContractTooltipOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		log.debug("Contract Tooltip started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		log.debug("Contract Tooltip stopped!");
	}

	@Provides
	ContractTooltipConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ContractTooltipConfig.class);
	}
}
