package com.github.apachecara.contracttooltip;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("contracttooltip")
public interface ContractTooltipConfig extends Config
{
	@ConfigItem(
		keyName = "showInBank",
		name = "Show in Bank",
		description = "Also show contract tooltips when hovering seeds in the bank",
		position = 0
	)
	default boolean showInBank()
	{
		return true;
	}
}
