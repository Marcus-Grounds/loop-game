package unsw.loopmania;

import unsw.loopmania.BasicItems.*;
import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Buildings.PathBuildings.PathBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.SpawnBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.VampireCastleBuilding;
import unsw.loopmania.Cards.*;
import unsw.loopmania.Enemies.*;
import unsw.loopmania.GameMode.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unsw.loopmania.BasicItems.Sword;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.VampireCastleCard;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.LoopManiaApplication;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */

 public class LoopManiaWorld {
    // TODO = add additional backend functionality

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    public static final int START_HEALTH = 100;
    public static final int START_EXP = 0;
    public static final int START_GOLD = 0;
    public static final int BASE_DAMAGE = 5;


    public static final int LOW_HEALTH = 10;
    public static final int MED_HEALTH = 30;
    public static final int HIGH_HEALTH = 100;

    public static final int LOW_DAMAGE = 2;
    public static final int MED_DAMAGE = 5;
    public static final int HIGH_DAMAGE = 10;

    public static final int LOW_EXP = 1;
    public static final int MED_EXP = 2;
    public static final int HIGH_EXP = 5;

    public static final int LOW_GOLD = 1;
    public static final int MED_GOLD = 2;
    public static final int HIGH_GOLD = 3;

    public static final int SHORT_RADIUS = 1;
    public static final int MED_RADIUS = 3;
    public static final int LONG_RADIUS = 5;

    public static final int GOAL_WIN_EXP = 500;
    public static final int GOAL_WIN_GOLD = 250;

    /**
     * width and height of the world in GridPane cells
     */
    private int width;
    private int height;
    private int loopCount;

    private List<Entity> nonSpecifiedEntities;
    private List<Gold> goldCollection;
    private HealthPotion thePotion;

    private Character character;
    private List<BasicEnemy> enemies;

    //private List<Building> buildingEntities;
    private Building heroCastle;
    
    private List<BattleBuilding> battleBuildings;
    private List<PathBuilding>   pathBuildings;
    private List<SpawnBuilding>  spawnBuildings;
    private List<Building> buildingsList;

    private List<Ally> allies;


    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        
        
        this.width = width;
        this.height = height;
        this.nonSpecifiedEntities = new ArrayList<>();
        this.character = null;
        this.enemies = new ArrayList<>();
        this.orderedPath = orderedPath;
        this.heroCastle = new HerosCastle(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        this.battleBuildings = new ArrayList<>();
        this.pathBuildings = new ArrayList<>();
        this.spawnBuildings = new ArrayList<>();
        this.buildingsList = new ArrayList<>();
        this.allies = new ArrayList<>();
        this.goldCollection = new ArrayList<>();
        thePotion = null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    ////////// CASTLE METHODS ///////////////
    public boolean checkCharacterOnCastle (MovingEntity character) {
        
        if ((character.getX() == heroCastle.getX()) && (character.getY() == heroCastle.getY())) {
            return true;
        } else {
            return false;
        }
    }
    
    public void updateLoopCount (MovingEntity character) {
        if (checkCharacterOnCastle(character)) {
            this.loopCount = this.loopCount + 1;
        }
    }

    public void setCastle (Building castle) {
        this.heroCastle = castle;
    }
    ////////// MOVING ENTITIES //////////////
    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    public void addBasicEnemy (BasicEnemy basicEnemy) {
        this.enemies.add(basicEnemy);
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }


    public List<BasicEnemy> getAllBasicEnemies () {
        return this.enemies;
    }

    ////////// CARD ENTITIES ///////////////
    public void addCard (Card card) {
        this.character.addCard(card);
    }

    public Card getCardByIndex (int index) {
        return this.character.getCardByIndex(index);
    }

    public List<Card> getAllCards () {
        return this.character.getAllCards();
    }

    public void addInventoryItem (Entity entity) {
        this.character.addInventoryItem(entity);
    }

    public List<Entity> getAllInventoryItems () {
        return this.character.getAllInventoryItems();
    }


    // BUILDINGS STUFF
    public void addBattleBuilding (BattleBuilding building) {
        this.battleBuildings.add(building);
    }

    public List<BattleBuilding> getAllBattleBuildings () {
        return this.battleBuildings;
    }

    public void addPathBuilding (PathBuilding building) {
        this.pathBuildings.add(building);
    }

    public List<PathBuilding> getAllPathBuildings () {
        return this.pathBuildings;
    }

    public void addSpawnBuilding (SpawnBuilding building) {
        this.spawnBuildings.add(building);
    }

    public List<SpawnBuilding> getAllSpawnBuildings () {
        return this.spawnBuildings;
    }

    public void addBuilding (Building building) {
        this.buildingsList.add(building);
    }

    public List<Building> getAllBuildings () {
        return this.buildingsList;
    }

    public List<Pair<Integer, Integer>> getOrderedPath () {
        return this.orderedPath;
    }

    public boolean isAdjacentToPath (Pair<Integer, Integer> cell) {
        int value0 = cell.getValue0();
        int value1 = cell.getValue1();
        boolean result = false;
        for (Pair<Integer, Integer> adj : this.orderedPath) {
            if (adj.getValue0() == value0 && adj.getValue1() == value1) return false;
            if (isAdjacent(adj.getValue0(), value0) && isAdjacent(adj.getValue1(), value1)) result = true;
        }
        return result;
    }

    public boolean isOnPath (Pair<Integer, Integer> cell) {
        int value0 = cell.getValue0();
        int value1 = cell.getValue1();
        for (Pair<Integer, Integer> adj : this.orderedPath) {
            if (adj.getValue0() == value0 && adj.getValue1() == value1) return true;
        }
        return false;
    }

    /**
     * get a randomly generated position which could be used to spawn an enemy
     * @return null if random choice is that wont be spawning an enemy or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition () {
        // TODO = modify this
        
        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }
    
    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies(){
                
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            //at the momeny we only spawn slug, will change later
            Slug enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
        }

        for (SpawnBuilding b : spawnBuildings) {
            BasicEnemy enemy = b.spawnAction(loopCount, checkCharacterOnCastle(character), b.findPathToSpawn(orderedPath), orderedPath);
            
            if (enemy != null) {
                
                enemies.add(enemy);
                spawningEnemies.add(enemy);
            }
        }
        
        return spawningEnemies;
    }

    private Pair<Integer, Integer> possiblySpawnPosition (int scale){
        // TODO = modify this
        
        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(scale);
        // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    public Gold possiblySpawnGold() {
        Random random = new Random();
        double r = random.nextDouble();

        if (r < 0.05) {
            Pair<Integer, Integer> pos = getRandomPosition();
            int indexInPath = orderedPath.indexOf(pos);
            PathPosition position = new PathPosition(indexInPath, orderedPath);
            Gold gold = new Gold(position.getX(), position.getY());
            gold.increaseGold(1);
            goldCollection.add(gold);
            return gold;
        }
        return null;
    }

    public void possiblyCollectGold() {
        for (Gold g: goldCollection){
            if (g.getX() == character.getX() && g.getY() == character.getY()){
                System.out.println("GOLDCOUNT");
                System.out.println(character.increaseGold(g));
                
                g.destroy();
                
            }
        }
    }
    
    
    public HealthPotion possiblySpawnHealthPotion() {
        Random random = new Random();
        double r = random.nextDouble();

        if (r < 0.50 && thePotion == null) {
            Pair<Integer, Integer> pos = getRandomPosition();
            int indexInPath = orderedPath.indexOf(pos);
            PathPosition position = new PathPosition(indexInPath, orderedPath);
            HealthPotion potion = new HealthPotion(position.getX(), position.getY());
            this.thePotion = potion;
            return potion;
        }
        return null;
    }

    public void possiblyCollectPotion() {
        if(thePotion != null){
            if (thePotion.getX() == character.getX() && thePotion.getY() == character.getY()){
                System.out.println("drinkPotion");
                //System.out.println(character.increaseGold(g));
                character.increaseHealth(100);
                thePotion.destroy();
                thePotion = null;
            }
        }
    }
    


    // Run battle once between one enemy and character
    public void runBattle(BasicEnemy enemyToFight) {
        
        // resets character damage before each battle so no exponential increase of battle
        // character.setDamage(character.getDamage());
        
        for (BattleBuilding b : battleBuildings) {
            b.buildingAction(character, enemyToFight);
        }
        
        character.decreaseHealth(enemyToFight.getDamage());
        enemyToFight.decreaseHealth(5);
        
        System.out.println(character.getCurrentHealth());
        System.out.println(enemyToFight.getCurrentHealth());

    }

    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     * @throws IOException
     */
    //public List<BasicEnemy> runBattles(LoopManiaWorldController world) {
    public List<BasicEnemy> runBattles(LoopManiaWorldController controller) throws IOException {

        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        
        for (BasicEnemy e: enemies){
            
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= Math.pow(e.getAttackRadius(),2)){
                BattleEnemyController battleEnemyController = controller.getBattleController();

                Battle battle = new Battle(character, battleEnemyController, enemies, e, battleBuildings, loopCount);
                battleEnemyController.setBattle(battle);
                try {
                    controller.switchToBattle();
                    //return newBattle.getDefeatedEnemies();
                    System.out.println("Defeated Enemies");
                    return battle.getDefeatedEnemies();
                    
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                defeatedEnemies = battle.getDefeatedEnemies();

            }

        }
        //System.out.println("enemy dead count in loopmaninaworld.java");
        //System.out.println(defeatedEnemies.size());
        return defeatedEnemies;
    }

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(BasicEnemy enemy){
        // if adding more cards than have, remove the first card...
        if (this.character.getAllCards().size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            removeCard(0);
        }

        Card card = enemy.giveCardWhenLooted(new SimpleIntegerProperty(this.character.getAllCards().size()), new SimpleIntegerProperty(0));
        //BasicItem item = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        System.out.println(character.getAllInventoryItems().size());
        if (card != null){
            this.character.getAllCards().add(card);
        }

        return card;

        
        //VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(this.character.getAllCards().size()), new SimpleIntegerProperty(0));
        //this.character.getAllCards().add(vampireCastleCard);
        //return vampireCastleCard;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed cards)
     * @param index the index of the card, from 0 to length-1
     */
    private void removeCard(int index){
        Card c = this.character.getAllCards().get(index);
        int x = c.getX();
        c.destroy();
        this.character.getAllCards().remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    /**
     * spawn a sword in the world and return the sword entity
     * @return a sword to be spawned in the controller as a JavaFX node
     */
    public BasicItem addUnequippedItem(BasicEnemy enemy){
        System.out.println("addUnequippedItem");
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new sword, as we know we have at least made a slot available...
        BasicItem item = enemy.giveWeaponWhenLooted(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        //BasicItem item = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        System.out.println(character.getAllInventoryItems().size());
        if (item != null){
            this.character.getAllInventoryItems().add(item);
        }
        
        System.out.println(character.getAllInventoryItems().size());
        return item;
    }

     /**
     * spawn a staff in the world and return the staff entity
     * @return a staff to be spawned in the controller as a JavaFX node
     */
    public Staff addUnequippedStaff(){
       
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest staff
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new staff, as we know we have at least made a slot available...
        Staff staff = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        this.character.getAllInventoryItems().add(staff);
        return staff;
    }

     /**
     * spawn a stake in the world and return the stake entity
     * @return a stake to be spawned in the controller as a JavaFX node
     */
    public Stake addUnequippedStake(){
        
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest stake
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new stake, as we know we have at least made a slot available...
        Stake stake = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        this.character.getAllInventoryItems().add(stake);
        return stake;
    }

     /**
     * spawn a shield in the world and return the shield entity
     * @return a shield to be spawned in the controller as a JavaFX node
     */
    public Shield addUnequippedShield(){
        
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest shield
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new shield, as we know we have at least made a slot available...
        Shield shield = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        this.character.getAllInventoryItems().add(shield);
        return shield;
    }

     /**
     * spawn a helmet in the world and return the helmet entity
     * @return a helmet to be spawned in the controller as a JavaFX node
     */
    public Helmet addUnequippedHelmet(){
        
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest helmet
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new helmet, as we know we have at least made a slot available...
        Helmet helmet = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        this.character.getAllInventoryItems().add(helmet);
        return helmet;
    }

     /**
     * spawn a armour in the world and return the armour entity
     * @return a armour to be spawned in the controller as a JavaFX node
     */
    public Armour addUnequippedArmour(){
        
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest armour
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new armour, as we know we have at least made a slot available...
        Armour armour = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        this.character.getAllInventoryItems().add(armour);
        return armour;
    }

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y){
        Entity item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves() {
    
        character.moveDownPath();;
        moveBasicEnemies();
        possiblyCollectGold();
        possiblyCollectPotion();
        
        for (PathBuilding p : pathBuildings) {
            p.pathAction(character, enemies);
        }
    }

    // Created for testing purposes
    public void runTickMovesCharacter() {
        
        character.moveDownPath();
        
        for (PathBuilding p : pathBuildings) {
            p.pathAction(character, enemies);
        }
    }
    
    // Created for testing purposes
    public void runTickMovesEnemies() {
        
        moveBasicEnemies();
        for (PathBuilding p : pathBuildings) {
            p.pathAction(character, enemies);
        }
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    /**
     * remove an item from the unequipped inventory
     * @param item item to be removed
     */
    private void removeUnequippedInventoryItem(Entity item){
        item.destroy();
        this.character.getAllInventoryItems().remove(item);
    }

    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    private Entity getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Entity e:  this.character.getAllInventoryItems()){
            if ((e.getX() == x) && (e.getY() == y)){
                return e;
            }
        }
        return null;
    }

    /**
     * remove item at a particular index in the unequipped inventory items list (this is ordered based on age in the starter code)
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Entity item =  this.character.getAllInventoryItems().get(index);
        item.destroy();
         this.character.getAllInventoryItems().remove(index);
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: this.character.getAllCards()){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {

        for (BasicEnemy e: enemies){
            e.move();
        }
    }

    
    private Pair<Integer, Integer> getRandomPosition() {
        Random rand = new Random();
        List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
        int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
        // inclusive start and exclusive end of range of positions not allowed
        int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
        int endNotAllowed = (indexPosition + 3)%orderedPath.size();
        // note terminating condition has to be != rather than < since wrap around...
        for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
            orderedPathSpawnCandidates.add(orderedPath.get(i));
        }

        // choose random choice
        Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

        return spawnPosition;
    }

    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Building convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        
        Card card = null;
        for (Card c: this.character.getAllCards()){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)) {
                card = c;
                break;
            }
        }
        Building newBuilding = null;
        // now spawn building
        if (card.isPlaceable(buildingNodeX, buildingNodeY, this.orderedPath)) {
            newBuilding = card.generateEntity(new SimpleIntegerProperty(buildingNodeX),
             new SimpleIntegerProperty(buildingNodeY));
            if (newBuilding instanceof SpawnBuilding) {
                spawnBuildings.add((SpawnBuilding) newBuilding);
            } else if (newBuilding instanceof BattleBuilding) {
                battleBuildings.add((BattleBuilding) newBuilding);
            } else if (newBuilding instanceof PathBuilding) {
                pathBuildings.add((PathBuilding)newBuilding);
            }
            buildingsList.add(newBuilding);
            card.destroy();
            this.character.getAllCards().remove(card);
            shiftCardsDownFromXCoordinate(cardNodeX);
        }
        // destroy the card
        return newBuilding;
    }

    public boolean isAdjacent (int x, int y) {
        if (x == y + 1 || x == y - 1) return true;
        return false;
    }
    /*
    public List<BasicEnemy> runBattles(LoopManiaWorldController world) {
        return null;
    }
    */

    public ArrayList<Pair<Integer, Integer>> getAllAllies() {
        return null;
    }
}
