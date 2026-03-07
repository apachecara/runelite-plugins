package com.github.apachecara.contracttooltip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Complete farming contract data sourced from the OSRS Wiki.
 * Maps seed item IDs to their contract tier info, quantities, and probabilities.
 *
 * Wiki: "All entries on the table for which the player meets the requirements
 * are given equal weighting when Jane decides what contract to give out."
 *
 * Totals: Easy=31, Medium=22, Hard=18 possible contracts (all unlocked).
 */
public final class ContractData
{
	private ContractData() {}

	public static final int EASY_TOTAL = 31;
	public static final int MEDIUM_TOTAL = 22;
	public static final int HARD_TOTAL = 18;

	public enum Tier
	{
		EASY, MEDIUM, HARD
	}

	public static class ContractEntry
	{
		public final Tier tier;
		public final String patchType;
		public final int seedPackTier;
		public final int seedsNeeded;
		public final String growthTime;
		public final int unlockLevel;

		public ContractEntry(Tier tier, String patchType, int seedPackTier, int seedsNeeded, String growthTime, int unlockLevel)
		{
			this.tier = tier;
			this.patchType = patchType;
			this.seedPackTier = seedPackTier;
			this.seedsNeeded = seedsNeeded;
			this.growthTime = growthTime;
			this.unlockLevel = unlockLevel;
		}

		/**
		 * Probability of being assigned this contract if all contracts in the tier are unlocked.
		 */
		public double probability()
		{
			switch (tier)
			{
				case EASY: return 1.0 / EASY_TOTAL;
				case MEDIUM: return 1.0 / MEDIUM_TOTAL;
				case HARD: return 1.0 / HARD_TOTAL;
				default: return 0;
			}
		}
	}

	private static final Map<Integer, List<ContractEntry>> CONTRACTS = new HashMap<>();

	static
	{
		// ============================
		// EASY CONTRACTS (Farming 45+)
		// ============================

		// Allotments (3 seeds each)
		add(5318, Tier.EASY, "Allotment", 1, 3, "40 min", 45);    // Potato
		add(5319, Tier.EASY, "Allotment", 1, 3, "40 min", 45);    // Onion
		add(5320, Tier.EASY, "Allotment", 1, 3, "40 min", 45);    // Cabbage
		add(5321, Tier.EASY, "Allotment", 1, 3, "40 min", 45);    // Tomato
		add(5322, Tier.EASY, "Allotment", 1, 3, "1 hr", 45);      // Sweetcorn
		add(5323, Tier.EASY, "Allotment", 1, 3, "1 hr", 45);      // Strawberry

		// Flowers (1 seed each)
		add(5096, Tier.EASY, "Flower", 1, 1, "20 min", 45);       // Marigold
		add(5097, Tier.EASY, "Flower", 1, 1, "20 min", 45);       // Rosemary
		add(5098, Tier.EASY, "Flower", 1, 1, "20 min", 45);       // Nasturtium
		add(5099, Tier.EASY, "Flower", 1, 1, "20 min", 45);       // Woad
		add(5100, Tier.EASY, "Flower", 1, 1, "20 min", 45);       // Limpwurt

		// Bushes (1 seed each)
		add(5101, Tier.EASY, "Bush", 2, 1, "1h 40m", 45);         // Redberry
		add(5102, Tier.EASY, "Bush", 2, 1, "2 hr", 45);           // Cadavaberry
		add(5103, Tier.EASY, "Bush", 2, 1, "2h 20m", 45);         // Dwellberry
		add(5104, Tier.EASY, "Bush", 2, 1, "2h 40m", 48);         // Jangerberry

		// Cactus
		add(5280, Tier.EASY, "Cactus", 3, 1, "9h 20m", 55);      // Cactus

		// Herbs (1 seed each)
		add(5291, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Guam
		add(5292, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Marrentill
		add(5293, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Tarromin
		add(5294, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Harralander
		add(5295, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Ranarr
		add(5296, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Toadflax
		add(5297, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Irit
		add(5298, Tier.EASY, "Herb", 2, 1, "1h 20m", 65);         // Avantoe

		// Trees (1 seed each)
		add(5312, Tier.EASY, "Tree", 3, 1, "3h 20m", 65);         // Oak (Acorn)
		add(5313, Tier.EASY, "Tree", 3, 1, "4h 40m", 65);         // Willow
		add(5314, Tier.EASY, "Tree", 3, 1, "5h 20m", 65);         // Maple

		// Fruit Trees (1 seed each)
		add(5283, Tier.EASY, "Fruit Tree", 3, 1, "16 hr", 85);    // Apple
		add(5284, Tier.EASY, "Fruit Tree", 3, 1, "16 hr", 85);    // Banana
		add(5285, Tier.EASY, "Fruit Tree", 3, 1, "16 hr", 85);    // Orange
		add(5286, Tier.EASY, "Fruit Tree", 3, 1, "16 hr", 85);    // Curry

		// ==============================
		// MEDIUM CONTRACTS (Farming 65+)
		// ==============================

		// Allotments
		add(5323, Tier.MEDIUM, "Allotment", 2, 3, "1 hr", 65);          // Strawberry
		add(5324, Tier.MEDIUM, "Allotment", 3, 3, "1h 20m", 65);        // Watermelon
		add(22879, Tier.MEDIUM, "Allotment", 2, 3, "1h 10m", 65);       // Snape grass

		// Flowers
		add(22005, Tier.MEDIUM, "Flower", 2, 1, "20 min", 65);          // White lily

		// Bushes
		add(5104, Tier.MEDIUM, "Bush", 3, 1, "2h 40m", 65);             // Jangerberry
		add(5105, Tier.MEDIUM, "Bush", 3, 1, "2h 40m", 65);             // Whiteberry
		add(5106, Tier.MEDIUM, "Bush", 3, 1, "2h 40m", 70);             // Poison ivy

		// Herbs
		add(5297, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 65);             // Irit
		add(5298, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 65);             // Avantoe
		add(5299, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 65);             // Kwuarm
		add(5300, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 65);             // Snapdragon
		add(5301, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 67);             // Cadantine
		add(5302, Tier.MEDIUM, "Herb", 3, 1, "1h 20m", 73);             // Lantadyme

		// Cactus
		add(5280, Tier.MEDIUM, "Cactus", 4, 1, "9h 20m", 65);           // Cactus
		add(22873, Tier.MEDIUM, "Cactus", 2, 1, "1h 10m", 65);          // Potato cactus

		// Trees
		add(5314, Tier.MEDIUM, "Tree", 4, 1, "5h 20m", 65);             // Maple
		add(5315, Tier.MEDIUM, "Tree", 4, 1, "6h 40m", 65);             // Yew
		add(5316, Tier.MEDIUM, "Tree", 4, 1, "8 hr", 75);               // Magic

		// Fruit Trees
		add(5286, Tier.MEDIUM, "Fruit Tree", 4, 1, "16 hr", 85);        // Curry
		add(5287, Tier.MEDIUM, "Fruit Tree", 4, 1, "16 hr", 85);        // Pineapple
		add(5288, Tier.MEDIUM, "Fruit Tree", 4, 1, "16 hr", 85);        // Papaya
		add(5289, Tier.MEDIUM, "Fruit Tree", 4, 1, "16 hr", 85);        // Palm

		// ============================
		// HARD CONTRACTS (Farming 85+)
		// ============================

		// Allotments
		add(5324, Tier.HARD, "Allotment", 4, 3, "1h 20m", 85);          // Watermelon
		add(22879, Tier.HARD, "Allotment", 3, 3, "1h 10m", 85);         // Snape grass

		// Flowers
		add(22005, Tier.HARD, "Flower", 3, 1, "20 min", 85);            // White lily

		// Bushes
		add(5105, Tier.HARD, "Bush", 4, 1, "2h 40m", 85);               // Whiteberry
		add(5106, Tier.HARD, "Bush", 4, 1, "2h 40m", 85);               // Poison ivy

		// Herbs
		add(5300, Tier.HARD, "Herb", 4, 1, "1h 20m", 85);               // Snapdragon
		add(5301, Tier.HARD, "Herb", 4, 1, "1h 20m", 85);               // Cadantine
		add(5302, Tier.HARD, "Herb", 4, 1, "1h 20m", 85);               // Lantadyme
		add(5303, Tier.HARD, "Herb", 4, 1, "1h 20m", 85);               // Dwarf weed
		add(5304, Tier.HARD, "Herb", 4, 1, "1h 20m", 85);               // Torstol

		// Cactus
		add(22873, Tier.HARD, "Cactus", 3, 1, "1h 10m", 85);            // Potato cactus

		// Trees
		add(5314, Tier.HARD, "Tree", 5, 1, "5h 20m", 85);               // Maple
		add(5315, Tier.HARD, "Tree", 5, 1, "6h 40m", 85);               // Yew
		add(5316, Tier.HARD, "Tree", 5, 1, "8 hr", 85);                 // Magic

		// Fruit Trees
		add(5289, Tier.HARD, "Fruit Tree", 5, 1, "16 hr", 85);          // Palm
		add(22877, Tier.HARD, "Fruit Tree", 5, 1, "16 hr", 85);         // Dragonfruit

		// Special
		add(22869, Tier.HARD, "Special", 5, 1, "13h 20m", 85);          // Celastrus
		add(22871, Tier.HARD, "Redwood", 5, 1, "4d 10h", 90);           // Redwood
	}

	private static void add(int seedId, Tier tier, String patchType, int seedPackTier, int seedsNeeded, String growthTime, int unlockLevel)
	{
		CONTRACTS.computeIfAbsent(seedId, k -> new ArrayList<>())
			.add(new ContractEntry(tier, patchType, seedPackTier, seedsNeeded, growthTime, unlockLevel));
	}

	/**
	 * Get all contract entries for a given seed item ID.
	 * Returns empty list if the seed is not part of any contract.
	 */
	public static List<ContractEntry> getContracts(int seedId)
	{
		return CONTRACTS.getOrDefault(seedId, Collections.emptyList());
	}

	/**
	 * Check if a seed is used in any farming contract.
	 */
	public static boolean isContractSeed(int seedId)
	{
		return CONTRACTS.containsKey(seedId);
	}
}
