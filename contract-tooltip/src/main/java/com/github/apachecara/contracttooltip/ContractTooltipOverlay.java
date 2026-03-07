package com.github.apachecara.contracttooltip;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class ContractTooltipOverlay extends WidgetItemOverlay
{
	private static final Color EASY_COLOR = new Color(0x55FF55);
	private static final Color MEDIUM_COLOR = new Color(0xFFFF55);
	private static final Color HARD_COLOR = new Color(0xFF5555);
	private static final Color HEADER_COLOR = new Color(0xFFAA00);
	private static final Color INFO_COLOR = new Color(0xCCCCCC);

	private final Client client;
	private final TooltipManager tooltipManager;
	private final ContractTooltipConfig config;

	@Inject
	ContractTooltipOverlay(Client client, TooltipManager tooltipManager, ContractTooltipConfig config)
	{
		this.client = client;
		this.tooltipManager = tooltipManager;
		this.config = config;
		showOnInventory();
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		List<ContractData.ContractEntry> contracts = ContractData.getContracts(itemId);
		if (contracts.isEmpty())
		{
			return;
		}

		// Only show tooltip if mouse is hovering over this item
		net.runelite.api.Point mousePos = client.getMouseCanvasPosition();
		if (mousePos == null)
		{
			return;
		}

		java.awt.Rectangle bounds = widgetItem.getCanvasBounds();
		if (bounds == null || !bounds.contains(mousePos.getX(), mousePos.getY()))
		{
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(colorTag(HEADER_COLOR)).append("Farming Contract Info</col>");

		for (ContractData.ContractEntry entry : contracts)
		{
			Color tierColor;
			String tierName;
			int tierTotal;

			switch (entry.tier)
			{
				case EASY:
					tierColor = EASY_COLOR;
					tierName = "Easy";
					tierTotal = ContractData.EASY_TOTAL;
					break;
				case MEDIUM:
					tierColor = MEDIUM_COLOR;
					tierName = "Medium";
					tierTotal = ContractData.MEDIUM_TOTAL;
					break;
				case HARD:
					tierColor = HARD_COLOR;
					tierName = "Hard";
					tierTotal = ContractData.HARD_TOTAL;
					break;
				default:
					continue;
			}

			double pct = entry.probability() * 100.0;

			sb.append("</br>");
			sb.append(colorTag(tierColor)).append(tierName).append("</col>");
			sb.append(colorTag(INFO_COLOR));
			sb.append(" | ").append(entry.patchType);
			sb.append(" | Seeds: ").append(entry.seedsNeeded);
			sb.append(" | Pack tier ").append(entry.seedPackTier);
			sb.append(" | ").append(String.format("%.1f%%", pct)).append(" (1/").append(tierTotal).append(")");
			sb.append(" | ").append(entry.growthTime);
			sb.append(" | Lv ").append(entry.unlockLevel);
			sb.append("</col>");
		}

		tooltipManager.add(new Tooltip(sb.toString()));
	}

	private static String colorTag(Color c)
	{
		return String.format("<col=%02x%02x%02x>", c.getRed(), c.getGreen(), c.getBlue());
	}
}
