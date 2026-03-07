package com.github.apachecara.seedtracker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Complete set of all seed/spore item IDs in OSRS.
 * Used to determine if an inventory item is a seed at all.
 */
public final class SeedIds
{
	private SeedIds() {}

	private static final Set<Integer> ALL_SEEDS;

	static
	{
		Set<Integer> seeds = new HashSet<>();

		// Herb seeds
		seeds.add(5291);  // Guam seed
		seeds.add(5292);  // Marrentill seed
		seeds.add(5293);  // Tarromin seed
		seeds.add(5294);  // Harralander seed
		seeds.add(5295);  // Ranarr seed
		seeds.add(5296);  // Toadflax seed
		seeds.add(5297);  // Irit seed
		seeds.add(5298);  // Avantoe seed
		seeds.add(5299);  // Kwuarm seed
		seeds.add(5300);  // Snapdragon seed
		seeds.add(5301);  // Cadantine seed
		seeds.add(5302);  // Lantadyme seed
		seeds.add(5303);  // Dwarf weed seed
		seeds.add(5304);  // Torstol seed

		// Allotment seeds
		seeds.add(5318);  // Potato seed
		seeds.add(5319);  // Onion seed
		seeds.add(5320);  // Cabbage seed
		seeds.add(5321);  // Tomato seed
		seeds.add(5322);  // Sweetcorn seed
		seeds.add(5323);  // Strawberry seed
		seeds.add(5324);  // Watermelon seed
		seeds.add(22879); // Snape grass seed

		// Flower seeds
		seeds.add(5096);  // Marigold seed
		seeds.add(5097);  // Rosemary seed
		seeds.add(5098);  // Nasturtium seed
		seeds.add(5099);  // Woad seed
		seeds.add(5100);  // Limpwurt seed

		// Hops seeds
		seeds.add(5305);  // Barley seed
		seeds.add(5306);  // Jute seed
		seeds.add(5307);  // Hammerstone seed
		seeds.add(5308);  // Asgarnian seed
		seeds.add(5309);  // Yanillian seed
		seeds.add(5310);  // Krandorian seed
		seeds.add(5311);  // Wildblood seed

		// Bush seeds
		seeds.add(5101);  // Redberry seed
		seeds.add(5102);  // Cadavaberry seed
		seeds.add(5103);  // Dwellberry seed
		seeds.add(5104);  // Jangerberry seed
		seeds.add(5105);  // Whiteberry seed
		seeds.add(5106);  // Poison ivy seed

		// Tree seeds
		seeds.add(5312);  // Acorn
		seeds.add(5313);  // Willow seed
		seeds.add(5314);  // Maple seed
		seeds.add(5315);  // Yew seed
		seeds.add(5316);  // Magic seed
		seeds.add(5317);  // Spirit seed

		// Fruit tree seeds
		seeds.add(5283);  // Apple tree seed
		seeds.add(5284);  // Banana tree seed
		seeds.add(5285);  // Orange tree seed
		seeds.add(5286);  // Curry tree seed
		seeds.add(5287);  // Pineapple seed
		seeds.add(5288);  // Papaya tree seed
		seeds.add(5289);  // Palm tree seed
		seeds.add(22877); // Dragonfruit tree seed

		// Special seeds
		seeds.add(5280);  // Cactus seed
		seeds.add(5281);  // Belladonna seed
		seeds.add(5282);  // Mushroom spore
		seeds.add(5290);  // Calquat tree seed
		seeds.add(22869); // Celastrus seed
		seeds.add(22871); // Redwood tree seed
		seeds.add(22873); // Potato cactus seed
		seeds.add(22875); // Hespori seed
		seeds.add(21490); // Seaweed spore
		seeds.add(22881); // Kronos seed
		seeds.add(22883); // Iasor seed
		seeds.add(22885); // Attas seed
		seeds.add(23661); // Crystal acorn

		ALL_SEEDS = Collections.unmodifiableSet(seeds);
	}

	public static boolean isSeed(int itemId)
	{
		return ALL_SEEDS.contains(itemId);
	}

	public static Set<Integer> getAllSeeds()
	{
		return ALL_SEEDS;
	}
}
