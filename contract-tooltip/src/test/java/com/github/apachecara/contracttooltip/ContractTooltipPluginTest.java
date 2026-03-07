package com.github.apachecara.contracttooltip;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ContractTooltipPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ContractTooltipPlugin.class);
		RuneLite.main(args);
	}
}