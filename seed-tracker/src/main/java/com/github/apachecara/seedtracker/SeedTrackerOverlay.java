package com.github.apachecara.seedtracker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

public class SeedTrackerOverlay extends WidgetItemOverlay
{
	private final Client client;
	private final SeedTrackerConfig config;

	@Inject
	SeedTrackerOverlay(Client client, SeedTrackerConfig config)
	{
		this.client = client;
		this.config = config;
		showOnInventory();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		if (!SeedIds.isSeed(itemId))
		{
			return;
		}

		Set<Integer> keepIds = parseKeepIds();
		int opacity = Math.max(0, Math.min(255, config.highlightOpacity()));

		Color color;
		if (keepIds.contains(itemId))
		{
			color = new Color(0, 255, 0, opacity);
		}
		else
		{
			color = new Color(255, 0, 0, opacity);
		}

		Rectangle bounds = widgetItem.getCanvasBounds();
		if (bounds != null)
		{
			graphics.setColor(color);
			graphics.fill(bounds);
		}
	}

	private Set<Integer> parseKeepIds()
	{
		String csv = config.keepSeedIds();
		if (csv == null || csv.trim().isEmpty())
		{
			return Collections.emptySet();
		}

		Set<Integer> ids = new HashSet<>();
		for (String part : csv.split(","))
		{
			String trimmed = part.trim();
			if (!trimmed.isEmpty())
			{
				try
				{
					ids.add(Integer.parseInt(trimmed));
				}
				catch (NumberFormatException e)
				{
					// skip invalid entries
				}
			}
		}
		return ids;
	}
}
