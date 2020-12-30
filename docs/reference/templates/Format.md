# Hypercube Template Format
> By 1pe and Technotype

This document is an attempt at trying to describe the Hypercube JSON template format, or more specifically, the objects that can go into the `blocks` array inside a Hypercube template.

If something is missing, please tell us and we'll document it.

## Field reference

| Field name | Required                                         | Description             | Type                        |
|------------|--------------------------------------------------|-------------------------|-----------------------------|
| `id`       | `true`                                           | The type of block.      | `"block"` or `"bracket"`    |
| `block`    | `true` if `id` is `"block"`, `false` otherwise   | The code block type.    | [Block types](#Block types) |
| `args`     | `true` if `id` is `"block"`, `false` otherwise   | Arguments for the block | Array of arguments          |
| `action`   | See [Block types](#Block types)                  | The blocks action.      | String, see block type.     |
| `type`     | `true` if `id` is `"bracket"`, `false` otherwise | The bracket type.       | `"norm"` or `"repeat"`      |
| `direct`   | `true` if `id` is `"bracket"`, `false` otherwise | The bracket direction.  | `"open"` or `"close"`       |
| `target`   | See [Block types](#Block types)                  | The Target              | [Targets](#Targets)         |
| `inverted` | See [Block types](#Block types)                  | NOT                     | "NOT" if null not there     |

### Block types

| Block name    | Identifier      | Requires `action` | Can have `target` | Invertable |
|---------------|-----------------|-------------------|-------------------|------------|
| Player Event  | `event`         | `true`            | `false`           | `false`    |
| Entity Event  | `entity_event`  | `true`            | `false`           | `false`    |
| Function      | `func`          | `false`           | `false`           | `false`    |
| Process       | `process`       | `false`           | `false`           | `false`    |
| If Player     | `if_player`     | `true`            | `true `           | `true`     |
| If Entity     | `if_entity`     | `true`            | `true `           | `true`     |
| If Game       | `if_game`       | `true`            | `false`           | `true`     |
| If Variable   | `if_var`        | `true`            | `false`           | `true`     |
| Else          | `else`          | `false`           | `false`           | `false`    |
| Player Action | `player_action` | `true`            | `true `           | `false`    |
| Entity Action | `entity_action` | `true`            | `true `           | `false`    |
| Game Action   | `game_action`   | `true`            | `false`           | `false`    |
| Select Object | `select_obj`    | `true`            | `false`           | `false`    |
| Set Variable  | `set_var`       | `true`            | `false`           | `false`    |
| Control       | `control`       | `true`            | `false`           | `false`    |
| Repeat        | `repeat`        | `true`            | `false`           | `false`    |
| Call Function | `call_func`     | `false`           | `false`           | `false`    |
| Start Process | `start_process` | `false`           | `false`           | `false`    |
## Arguments

## Variable types

| Variable name     | Identifier | Description                              |
|-------------------|------------|------------------------------------------|
| Text              | `txt`      | [Text](#Text)                            |
| Number            | `num`      | [Numbers](#Numbers)                      |
| Location          | `loc`      | [Locations](#Locations)                  |
| Sound             | `snd`      | [Sounds](#Sounds)                        |
| Relative location | `r_loc`    | [Relative Location](#Relative locations) |
| Vector            | `vec`      | [Vectors](#Vectors)                      |
| Particle          | `part`     | [Particle](#Particles)                   |
| Potion effect     | `pot`      | [Potion Effect](#Potions)                |
| Dynamic variable  | `var`      | [Variables](#Variables)                  |
| Game value        | `g_val`    | [Game Values](#Game values)              |

### Text

| Data   | Description      |
|--------|------------------|
| `name` | The String Value |

### Numbers

Number limit: `9223372036854775.807`
All numbers are stored as 64-bit signed integers.

| Data   | Description         |
|--------|---------------------|
| `name` | The numerical value |

### Locations

| Data      | Description           | Type                                |
|-----------|-----------------------|-------------------------------------|
| `loc`     | The location value.   | [Location object](#Location object) |
| `isBlock` | Not in use.           | Boolean                             |

#### Location object

| Field name | Description               | Type     |
|------------|---------------------------|----------|
| `x`        | The X coordinate          | Double   |
| `y`        | The Y coordinate          | Double   |
| `z`        | The Z coordinate          | Double   |
| `pitch`    | The Pitch of the locaiton | Double   |
| `yaw`      | The Yaw of the location   | Double   |

### Sounds

| Data       | Description                             | Type                            |
|------------|-----------------------------------------|---------------------------------|
| `sound`    | The ID of the sound to be played        | See [Sound types](#Sound types) |
| `pitch`    | The pitch of the sound (Default: 1.0)   | Double                          |
| `vol`      | The volume of the sound  (Default: 2.0) | Double                          |

<details>
<summary>Sound types</summary>
DiamondFire sound IDs are custom, and then when played mapped to their corresponding Minecraft sound.

| Name                                        | Minecraft ID                                   |
|---------------------------------------------|------------------------------------------------|
| `Wither Ambient`                            | `entity.wither.ambient`                        |
| `Wither Break Block`                        | `entity.wither.break_block`                    |
| `Wither Death`                              | `entity.wither.death`                          |
| `Wither Hurt`                               | `entity.wither.hurt`                           |
| `Wither Shoot`                              | `entity.wither.shoot`                          |
| `Wither Spawn`                              | `entity.wither.spawn`                          |
| `Wither Skeleton Ambient`                   | `entity.wither_skeleton.ambient`               |
| `Wither Skeleton Death`                     | `entity.wither_skeleton.death`                 |
| `Wither Skeleton Hurt`                      | `entity.wither_skeleton.hurt`                  |
| `Wither Skeleton Step`                      | `entity.wither_skeleton.step`                  |
| `Zombie Ambient`                            | `entity.zombie.ambient`                        |
| `Zombie Attack Wooden Door`                 | `entity.zombie.attack_wooden_door`             |
| `Zombie Attack Iron Door`                   | `entity.zombie.attack_iron_door`               |
| `Zombie Break Wooden Door`                  | `entity.zombie.break_wooden_door`              |
| `Zombie Death`                              | `entity.zombie.death`                          |
| `Zombie Destroy Egg`                        | `entity.zombie.destroy_egg`                    |
| `Zombie Drown`                              | `entity.zombie.converted_to_drowned`           |
| `Zombie Infect`                             | `entity.zombie.infect`                         |
| `Zombie Hurt`                               | `entity.zombie.hurt`                           |
| `Zombie Step`                               | `entity.zombie.step`                           |
| `Zombie Pigman Ambient`                     | `entity.piglin.ambient`                        |
| `Zombie Pigman Angry`                       | `entity.piglin.angry`                          |
| `Zombie Pigman Death`                       | `entity.piglin.death`                          |
| `Zombie Pigman Hurt`                        | `entity.piglin.hurt`                           |
| `Zombie Villager Ambient`                   | `entity.zombie_villager`                       |
| `Zombie Villager Convert`                   | `entity.zombie_villager.converted`             |
| `Zombie Villager Cure`                      | `entity.zombie_villager.cure`                  |
| `Zombie Villager Death`                     | `entity.zombie_villager.death`                 |
| `Zombie Villager Hurt`                      | `entity.zombie_villager.hurt`                  |
| `Zombie Villager Step`                      | `entity.zombie_villager.step`                  |
| `Player Attack (Critical)`                  | `entity.player.attack.crit`                    |
| `Player Attack (Knockback)`                 | `entity.player.attack.knockback`               |
| `Player Attack (No Damage)`                 | `entity.player.attack.nodamage`                |
| `Player Attack (Strong)`                    | `entity.player.attack.strong`                  |
| `Player Attack (Sweep)`                     | `entity.player.attack.sweep`                   |
| `Player Attack (Weak)`                      | `entity.player.attack.weak`                    |
| `Player Breathe`                            | `entity.player.breath`                         |
| `Player Burn`                               | `entity.player.hurt_on_fire`                   |
| `Player Burp`                               | `entity.player.burp`                           |
| `Player Drown`                              | `entity.player.hurt_drown`                     |
| `Player Hurt (Sweet Berry Bush)`            | `entity.player.hurt_sweet_berry_bush`          |
| `Player Level Up`                           | `entity.player.levelup`                        |
| `Player Splash (High Speed)`                | `entity.player.splash.high_speed`              |
| `Death`                                     | `entity.generic.death`                         |
| `Drink`                                     | `entity.generic.drink`                         |
| `Eat`                                       | `entity.generic.eat`                           |
| `Extinguish`                                | `entity.generic.extinguish_fire`               |
| `Fall`                                      | `entity.generic.small_fall`                    |
| `Fall (Big)`                                | `entity.generic.big_fall`                      |
| `Hurt`                                      | `entity.generic.hurt`                          |
| `Splash`                                    | `entity.generic.splash`                        |
| `Swim`                                      | `entity.generic.swim`                          |
| `Challenge Complete`                        | `ui.toast.challenge_complete`                  |
| `UI Button Click`                           | `ui.button.click`                              |
| `UI Toast In`                               | `ui.toast.in`                                  |
| `UI Toast Out`                              | `ui.toast.out`                                 |
| `Arrow Hit`                                 | `entity.arrow.hit`                             |
| `Arrow Hit Player`                          | `entity.arrow.hit_player`                      |
| `Arrow Shoot`                               | `entity.arrow.shoot`                           |
| `Egg Throw`                                 | `entity.egg.throw`                             |
| `Ender Eye Death`                           | `entity.ender_eye.death`                       |
| `Ender Eye Launch`                          | `entity.ender_eye.launch`                      |
| `Enderpearl Throw`                          | `entity.ender_pearl.throw`                     |
| `Experience Bottle Throw`                   | `entity.experience_bottle.throw`               |
| `Lingering Potion Throw`                    | `entity.lingering_potion.throw`                |
| `Splash Potion Break`                       | `entity.splash_potion.break`                   |
| `Splash Potion Throw`                       | `entity.splash_potion.throw`                   |
| `Snowball Throw`                            | `entity.snowball.throw`                        |
| `Firework Blast`                            | `entity.firework_rocket.blast`                 |
| `Firework Blast Far`                        | `entity.firework_rocket.blast_far`             |
| `Firework Large Blast`                      | `entity.firework_rocket.large_blast`           |
| `Firework Large Blast Far`                  | `entity.firework_rocket.large_blast_far`       |
| `Firework Launch`                           | `entity.firework_rocket.launch`                |
| `Firework Shoot`                            | `entity.firework_rocket.shoot`                 |
| `Firework Twinkle`                          | `entity.firework_rocket.twinkle`               |
| `Firework Twinkle Far`                      | `entity.firework_rocket.twinkle_far`           |
| `Item Frame Add Item`                       | `entity.item_frame.add_item`                   |
| `Item Frame Break`                          | `entity.item_frame.break`                      |
| `Item Frame Place`                          | `entity.item_frame.place`                      |
| `Item Frame Remove Item`                    | `entity.item_frame.remove_item`                |
| `Item Frame Rotate Item`                    | `entity.item_frame.rotate_item`                |
| `Painting Break`                            | `entity.painting.break`                        |
| `Painting Place`                            | `entity.painting.place`                        |
| `Boat Paddle Land`                          | `entity.boat.paddle_land`                      |
| `Boat Paddle Water`                         | `entity.boat.paddle_water`                     |
| `Minecart Inside`                           | `entity.minecart.inside`                       |
| `Rolling Minecart`                          | `entity.minecart.riding`                       |
| `Armorstand Break`                          | `entity.armor_stand.break`                     |
| `Armorstand Fall`                           | `entity.armor_stand.fall`                      |
| `Armorstand Hit`                            | `entity.armor_stand.hit`                       |
| `Armorstand Place`                          | `entity.armor_stand.place`                     |
| `Burn`                                      | `entity.generic.burn`                          |
| `Experience Orb Pickup`                     | `entity.experience_orb.pickup`                 |
| `Leash Knot Break`                          | `entity.leash_knot.break`                      |
| `Leash Knot Place`                          | `entity.leash_knot.place`                      |
| `TNT Primed`                                | `entity.tnt.primed`                            |
| `Creative Music`                            | `music.creative`                               |
| `Credits Music`                             | `music.credits`                                |
| `Boss Music`                                | `music.dragon`                                 |
| `End Music`                                 | `music.end`                                    |
| `Overworld Music`                           | `music.game`                                   |
| `Menu Music`                                | `music.menu`                                   |
| `Nether Music`                              | `music.nether`                                 |
| `Underwater Music`                          | `music.under_water`                            |
| `Music Disc - 11`                           | `music_disc.11`                                |
| `Music Disc -  13`                          | `music_disc.13`                                |
| `Music Disc - Blocks`                       | `music_disc.blocks`                            |
| `Music Disc - Cat`                          | `music_disc.cat`                               |
| `Music Disc - Chirp`                        | `music_disc.chirp`                             |
| `Music Disc - Far`                          | `music_disc.far`                               |
| `Music Disc - Mall`                         | `music_disc.mall`                              |
| `Music Disc - Mellohi`                      | `music_disc.mellohi`                           |
| `Music Disc - Stal`                         | `music_disc.stal`                              |
| `Music Disc - Strad`                        | `music_disc.strad`                             |
| `Music Disc - Ward`                         | `music_disc.ward`                              |
| `Music Disc - Wait`                         | `music_disc.wait`                              |
| `Shield Block`                              | `item.shield.block`                            |
| `Shield Break`                              | `item.shield.break`                            |
| `Crossbow Hit`                              | `item.crossbow.hit`                            |
| `Crossbow Loading (End)`                    | `item.crossbow.loading_end`                    |
| `Crossbow Loading (Middle)`                 | `item.crossbow.loading_middle`                 |
| `Crossbow Loading (Start)`                  | `item.crossbow.loading_start`                  |
| `Crossbow Quick Charge (I)`                 | `item.crossbow.quick_charge_1`                 |
| `Crossbow Quick Charge (II)`                | `item.crossbow.quick_charge_2`                 |
| `Crossbow Quick Charge (III)`               | `item.crossbow.quick_charge_3`                 |
| `Crossbow Shoot`                            | `item.crossbow.shoot`                          |
| `Armor Equip`                               | `item.armor.equip_generic`                     |
| `Armor Equip (Elytra)`                      | `item.armor.equip_elytra`                      |
| `Armor Equip (Leather)`                     | `item.armor.equip_leather`                     |
| `Armor Equip (Chain)`                       | `item.armor.equip_chain`                       |
| `Armor Equip (Iron)`                        | `item.armor.equip_iron`                        |
| `Armor Equip (Gold)`                        | `item.armor.equip_gold`                        |
| `Armor Equip (Diamond)`                     | `item.armor.equip_diamond`                     |
| `Armor Equip (Turtle)`                      | `item.armor.equip_turtle`                      |
| `Elytra Flying`                             | `item.elytra.flying`                           |
| `Thorns Hit`                                | `enchant.thorns.hit`                           |
| `Trident Throw`                             | `item.trident.throw`                           |
| `Trident Hit`                               | `item.trident.hit`                             |
| `Trident Hit Ground`                        | `item.trident.hit_ground`                      |
| `Trident Return`                            | `item.trident.return`                          |
| `Trident Riptide (I)`                       | `item.trident.riptide_1`                       |
| `Trident Riptide (II)`                      | `item.trident.riptide_2`                       |
| `Trident Riptide (III)`                     | `item.trident.riptide_3`                       |
| `Trident Thunder`                           | `item.trident.thunder`                         |
| `Fire Charge Use`                           | `item.firecharge.use`                          |
| `Flint and Steel Use`                       | `item.flintandsteel.use`                       |
| `Axe Strip`                                 | `item.axe.strip`                               |
| `Hoe Till`                                  | `item.hoe.till`                                |
| `Shovel Flatten`                            | `item.shovel.flatten`                          |
| `Fishing Bobber Retrieve`                   | `entity.fishing_bobber.retrieve`               |
| `Fishing Bobber Splash`                     | `entity.fishing_bobber.splash`                 |
| `Fishing Bobber Throw`                      | `entity.fishing_bobber.throw`                  |
| `Bottle Empty`                              | `item.bottle.empty`                            |
| `Bottle Fill`                               | `item.bottle.fill`                             |
| `Dragon Breath Fill`                        | `item.bottle.fill_dragonbreath`                |
| `Honey Bottle Drink`                        | `item.honey_bottle.drink`                      |
| `Bucket Empty`                              | `item.bucket.empty`                            |
| `Bucket Fill`                               | `item.bucket.fill`                             |
| `Fish Buck Empty`                           | `item.bucket.empty_fish`                       |
| `Fish Bucket Fill`                          | `item.bucket.fill_fish`                        |
| `Lava Bucket Empty`                         | `item.bucket.empty_lava`                       |
| `Lava Bucket Fill`                          | `item.bucket.fill_lava`                        |
| `Item Break`                                | `entity.item.break`                            |
| `Item Pickup`                               | `entity.item.pickup`                           |
| `Book Page Turn`                            | `item.book.page_turn`                          |
| `Book Put in Lectern`                       | `item.book.put`                                |
| `Chorus Fruit Teleport`                     | `item.chorus_fruit.teleport`                   |
| `Totem Use`                                 | `item.totem.use`                               |
| `Anvil Place`                               | `block.anvil.place`                            |
| `Bamboo Place`                              | `block.bamboo.place`                           |
| `Bamboo Sapling Place`                      | `block.bamboo_sapling.place`                   |
| `Coral Block Place`                         | `block.coral_block.place`                      |
| `Crop Plant`                                | `item.crop.plant`                              |
| `Glass Place`                               | `block.glass.place`                            |
| `Grass Place`                               | `block.grass.place`                            |
| `Gravel Place`                              | `block.gravel.place`                           |
| `Honey Block Place`                         | `block.honey_block.place`                      |
| `Lily Pad Place`                            | `block.lily_pad.place`                         |
| `Ladder Place`                              | `block.ladder.place`                           |
| `Lantern Place`                             | `block.lantern.place`                          |
| `Metal Place`                               | `block.metal.place`                            |
| `Nether Wart Plant`                         | `item.nether_wart.plant`                       |
| `Sand Place`                                | `block.sand.place`                             |
| `Scaffolding Place`                         | `block.scaffolding.place`                      |
| `Seagrass Place`                            | `block.wet_grass.place`                        |
| `Slime Place`                               | `block.slime_block.place`                      |
| `Snow Place`                                | `block.snow.place`                             |
| `Stone Place`                               | `block.stone.place`                            |
| `Sweet Berry Bush Place`                    | `block.sweet_berry_bush.place`                 |
| `Wood Place`                                | `block.wood.place`                             |
| `Wool Place`                                | `block.wool.place`                             |
| `Anvil Break`                               | `block.anvil.break`                            |
| `Bamboo Break`                              | `block.bamboo.break`                           |
| `Bamboo Sapling Break`                      | `block.bamboo_sapling.break`                   |
| `Coral Block Break`                         | `block.coral_block.break`                      |
| `Crop Break`                                | `block.crop.break`                             |
| `Glass Break`                               | `block.glass.break`                            |
| `Grass Break`                               | `block.grass.break`                            |
| `Gravel Break`                              | `block.gravel.break`                           |
| `Honey Block Break`                         | `block.honey_block.break`                      |
| `Ladder Break`                              | `block.ladder.break`                           |
| `Lantern Break`                             | `block.lantern.break`                          |
| `Metal Break`                               | `block.metal.break`                            |
| `Nether Wart Break`                         | `block.nether_wart.break`                      |
| `Sand Break`                                | `block.sand.break`                             |
| `Block Scaffolding Break`                   | `block.scaffolding.break`                      |
| `Seagrass Break`                            | `block.wet_grass.break`                        |
| `Slime Break`                               | `block.slime.break`                            |
| `Snow Break`                                | `block.snow.break`                             |
| `Stone Break`                               | `block.stone.break`                            |
| `Sweet Berry Bush Break`                    | `block.sweet_berry_bush.break`                 |
| `Wood Break`                                | `block.wood.break`                             |
| `Wool Break`                                | `block.wool.break`                             |
| `Anvil Step`                                | `block.anvil.step`                             |
| `Bamboo Step`                               | `block.bamboo.step`                            |
| `Coral Block Step`                          | `block.coral_block.step`                       |
| `Glass Step`                                | `block.glass.step`                             |
| `Grass Step`                                | `block.grass.step`                             |
| `Gravel Step`                               | `block.gravel.step`                            |
| `Honey Block Step`                          | `block.honey_block.step`                       |
| `Honey Block Slide`                         | `block.honey_block.slide`                      |
| `Ladder Step`                               | `block.ladder.step`                            |
| `Lantern Step`                              | `block.lantern.step`                           |
| `Metal Step`                                | `block.metal.step`                             |
| `Sand Step`                                 | `block.sand.step`                              |
| `Scaffolding Step`                          | `block.scaffolding.step`                       |
| `Seagrass Step`                             | `block.wet_grass.step`                         |
| `Slime Step`                                | `block.slime_block.step`                       |
| `Snow Step`                                 | `block.snow.step`                              |
| `Stone Step`                                | `block.stone.step`                             |
| `Wood Step`                                 | `block.wood.step`                              |
| `Wool Step`                                 | `block.wool.step`                              |
| `Anvil Fall`                                | `block.anvil.fall`                             |
| `Bamboo Fall`                               | `block.bamboo.fall`                            |
| `Coral Block Fall`                          | `block.coral_block.fall`                       |
| `Glass Fall`                                | `block.glass.fall`                             |
| `Grass Fall`                                | `block.grass.fall`                             |
| `Gravel Fall`                               | `block.gravel.fall`                            |
| `Honey Block Fall`                          | `block.honey_block.fall`                       |
| `Ladder Fall`                               | `block.ladder.fall`                            |
| `Lantern Fall`                              | `block.lantern.fall`                           |
| `Metal Fall`                                | `block.metal.fall`                             |
| `Sand Fall`                                 | `block.sand.fall`                              |
| `Scaffolding Fall`                          | `block.scaffolding.fall`                       |
| `Seagrass Fall`                             | `block.wet_grass.fall`                         |
| `Slime Fall`                                | `block.slime_block.fall`                       |
| `Snow Fall`                                 | `block.snow.fall`                              |
| `Stone Fall`                                | `block.stone.fall`                             |
| `Wood Fall`                                 | `block.wood.fall`                              |
| `Wool Fall`                                 | `block.wool.fall`                              |
| `Anvil Hit`                                 | `block.anvil.hit`                              |
| `Bamboo Hit`                                | `block.bamboo.hit`                             |
| `Bamboo Sapling Hit`                        | `block.bamboo_sapling.hit`                     |
| `Coral Block Hit`                           | `block.coral_block.hit`                        |
| `Glass Hit`                                 | `block.glass.hit`                              |
| `Grass Hit`                                 | `block.grass.hit`                              |
| `Gravel Hit`                                | `block.gravel.hit`                             |
| `Honey Block Hit`                           | `block.honey_block.hit`                        |
| `Ladder Hit`                                | `block.ladder.hit`                             |
| `Lantern Hit`                               | `block.lantern.hit`                            |
| `Metal Hit`                                 | `block.metal.hit`                              |
| `Sand Hit`                                  | `block.sand.hit`                               |
| `Scaffolding Hit`                           | `block.scaffolding.hit`                        |
| `Seagrass Hit`                              | `block.wet_grass.hit`                          |
| `Slime Hit`                                 | `block.slime_block.hit`                        |
| `Snow Hit`                                  | `block.snow.hit`                               |
| `Stone Hit`                                 | `block.stone.hit`                              |
| `Wood Hit`                                  | `block.wood.hit`                               |
| `Wool Hit`                                  | `block.wool.hit`                               |
| `Anvil Destroy`                             | `block.anvil.destroy`                          |
| `Anvil Land`                                | `block.anvil.land`                             |
| `Anvil Use`                                 | `block.anvil.use`                              |
| `Blast Furnace Fire Crackle`                | `block.blastfurnace.fire_crackle`              |
| `Brewing Stand Brew`                        | `block.brewing_stand.brew`                     |
| `Cartography Table Take Result`             | `ui.cartography_table.take_Result`             |
| `Composter Empty`                           | `block.composter.empty`                        |
| `Composter Fill`                            | `block.composter.fill`                         |
| `Composter Fill Success`                    | `block.composter.fill.success`                 |
| `Composter Ready`                           | `block.composter.ready`                        |
| `Enchantment Table Use`                     | `block.enchantment_table.use`                  |
| `Furnace Fire Crackle`                      | `block.furnace.fire_cracle`                    |
| `Grindstone Use`                            | `block.grindstone.use`                         |
| `Loom Select Pattern`                       | `ui.loom.select_pattern`                       |
| `Loom Take Result`                          | `ui.loom.take_result`                          |
| `Smoker Smoke`                              | `block.smoker.smoke`                           |
| `Stonecutter Select Recipe`                 | `ui.stonecutter.select_recipe`                 |
| `Stonecutter Take Result`                   | `ui.stonecutter.take_result`                   |
| `Beehive Drip`                              | `block.beehive.drip`                           |
| `Beehive Enter`                             | `block.beehive.enter`                          |
| `Beehive Exit`                              | `block.beehive.exit`                           |
| `Beehive Shear`                             | `block.beehive.shear`                          |
| `Beehive Work`                              | `block.beehive.work`                           |
| `Bubble Column Bubble Pop`                  | `block.bubble_column.bubble_pop`               |
| `Bubble Column Ambient (Up)`                | `block.bubble_column.upwards_ambient`          |
| `Bubble Column Inside (Up)`                 | `block.bubble_column.upwards_inside`           |
| `Bubble Column Ambient (Down)`              | `block.bubble_column.whirlpool_ambient`        |
| `Bubble Column Inside (Down)`               | `block.bubble_column.whirlpool_inside`         |
| `Campfire Crackle`                          | `block.campfire.crackle`                       |
| `Chorus Flower Death`                       | `block.chorus_flower.death`                    |
| `Chorus Flower Grow`                        | `block.chorus_flower.grow`                     |
| `Fire Ambient`                              | `block.fire.ambient`                           |
| `Fire Extinguish`                           | `block.fire.extinguish`                        |
| `Lava Extinguish`                           | `block.lava.extinguish`                        |
| `Pumpkin Carve`                             | `block.pumpkin.carve`                          |
| `Sweet Berry Bush Pick`                     | `item.sweet_berries.pick_from_bush`            |
| `Chest Close`                               | `block.chest.close`                            |
| `Chest Locked`                              | `block.chest.locked`                           |
| `Chest Open`                                | `block.chest.open`                             |
| `Barrel Close`                              | `block.barrel.close`                           |
| `Barrel Open`                               | `block.barrel.open`                            |
| `Ender Chest Close`                         | `block.ender_chest.close`                      |
| `Ender Chest Open`                          | `block.ender_chest.open`                       |
| `Shulker Box Close`                         | `block.shulker_box.close`                      |
| `Shulker Box Open`                          | `block.shulker_box.open`                       |
| `Piston Contract`                           | `block.piston.contract`                        |
| `Piston Extend`                             | `block.piston.extend`                          |
| `Fence Gate Close`                          | `block.fence_gate.close`                       |
| `Fence Gate Open`                           | `block.fence_gate.open`                        |
| `Lever Click`                               | `block.lever.click`                            |
| `Comparator Click`                          | `block.comparator.click`                       |
| `Iron Door Close`                           | `block.iron_door.close`                        |
| `Iron Door Open`                            | `block.iron_door.open`                         |
| `Iron Trapdoor Close`                       | `block.iron_trapdoor.close`                    |
| `Iron Trapdoor Open`                        | `block.iron_trapdoor.open`                     |
| `Metal Pressure Plate Click Off`            | `block.metal_pressure_plate.click_off`         |
| `Metal Pressure Plate Click On`             | `block.metal_pressure_plate.click_on`          |
| `Stone Button Click Off`                    | `block.stone_button.click_off`                 |
| `Stone Button Click On`                     | `block.stone_button.click_on`                  |
| `Stone Pressure Plate Click Off`            | `block.stone_pressure_plate.click_off`         |
| `Stone Pressure Plate Click On`             | `block.stone_pressure_plate.click_on`          |
| `Tripwire Attach`                           | `block.tripwire.attach`                        |
| `Tripwire Click Off`                        | `block.tripwire.click_off`                     |
| `Tripwire Click On`                         | `block.tripwire.click_on`                      |
| `Tripwire Detach`                           | `block.tripwire.detach`                        |
| `Wooden Pressure Plate Click Off`           | `block.wooden_pressure_plate.click_off`        |
| `Wooden Pressure Plate Click On`            | `block.wooden_pressure_plate.click_on`         |
| `Wooden Button Click Off`                   | `block.wooden_button.click_off`                |
| `Wooden Button Click On`                    | `block.wooden_button.click_on`                 |
| `Wooden Door Close`                         | `block.wooden_door.close`                      |
| `Wooden Door Open`                          | `block.wooden_door.open`                       |
| `Wooden Trapdoor Close`                     | `block.wooden_trapdoor.close`                  |
| `Wooden Trapdoor Open`                      | `block.wooden_trapdoor.open`                   |
| `Bass Drum`                                 | `block.note_block.basedrum`                    |
| `Banjo`                                     | `block.note_block.banjo`                       |
| `Bass`                                      | `block.note_block.bass`                        |
| `Bell`                                      | `block.note_block.bell`                        |
| `Bit`                                       | `block.note_block.bit`                         |
| `Chime`                                     | `block.note_block.chime`                       |
| `Cow Bell`                                  | `block.note_block.cow_bell`                    |
| `Didgeridoo`                                | `block.note_block.didgeridoo`                  |
| `Flute`                                     | `block.note_block.flute`                       |
| `Guitar`                                    | `block.note_block.guitar`                      |
| `Harp`                                      | `block.note_block.harp`                        |
| `Pling`                                     | `block.note_block.pling`                       |
| `Click`                                     | `block.note_block.hat`                         |
| `Snare Drum`                                | `block.note_block.snare`                       |
| `Iron Xylophone`                            | `block.note_block.iron_xylophone`              |
| `Xylophone`                                 | `block.note_block.xylophone`                   |
| `Beacon Ambient`                            | `block.beacon.ambient`                         |
| `Beacon Activate`                           | `block.beacon.activate`                        |
| `Beacon Deactivate`                         | `block.beacon.deactivate`                      |
| `Beacon Power Select`                       | `block.beacon.power_select`                    |
| `Conduit Activate`                          | `block.conduit.activate`                       |
| `Conduit Ambient`                           | `block.conduit.ambient`                        |
| `Conduit Ambient (Short)`                   | `block.conduit.ambient.short`                  |
| `Conduit Attack Target`                     | `block.conduit.attack.target`                  |
| `Conduit Deactivate`                        | `block.conduit.deactivate`                     |
| `Dispenser Dispense`                        | `block.dispenser.dispense`                     |
| `Dispenser Fail`                            | `block.dispenser.fail`                         |
| `Dispenser Launch`                          | `block.dispenser.launch`                       |
| `Bell Use`                                  | `block.bell.use`                               |
| `Bell Resonate`                             | `block.bell.resonate`                          |
| `Ambient Portal`                            | `block.portal.ambient`                         |
| `Portal Trigger`                            | `block.portal.trigger`                         |
| `Portal Travel`                             | `block.portal.travel`                          |
| `End Portal Fill Frame`                     | `block.end_portal_frame.fill`                  |
| `End Portal Spawn`                          | `block.end_portal.spawn`                       |
| `End Gateway Spawn`                         | `block.end_gateway.spawn`                      |
| `Redstone Torch Burnout`                    | `block.redstone_torch.burnout`                 |
| `Ambient Lava`                              | `block.lava.ambient`                           |
| `Lava Pop`                                  | `block.lava.pop`                               |
| `Lightning Impact`                          | `entity.lightning_bolt.impact`                 |
| `Lightning Thunder`                         | `entity.lightning_bolt.thunder`                |
| `Ambient Water`                             | `block.water.ambient`                          |
| `Ambient Cave`                              | `ambient.cave`                                 |
| `Underwater Ambience`                       | `ambient.underwater.loop`                      |
| `Underwater Ambience Additions`             | `ambient.underwater.loop.additions`            |
| `Underwater Ambience Additions (Rare)`      | `ambient.underwater.loop.additions.rare`       |
| `Underwater Ambience Additions (Very Rare)` | `ambient.underwater.loop.additions.ultra_rare` |
| `Enter Water`                               | `ambient.underwater.enter`                     |
| `Exit Water`                                | `ambient.underwater.exit`                      |
| `Weather Rain`                              | `weather.rain`                                 |
| `Weather Rain Above`                        | `weather.rain.above`                           |
| `Raid Horn`                                 | `event.raid.horn`                              |
| `Bat Ambient`                               | `entity.bat.ambient`                           |
| `Bat Death`                                 | `entity.bat.death`                             |
| `Bat Fly`                                   | `entity.bat.loop`                              |
| `Bat Hurt`                                  | `entity.bat.hurt`                              |
| `Bat Takeoff`                               | `entity.bat.takeoff`                           |
| `Bee Death`                                 | `entity.bee.death`                             |
| `Bee Hurt`                                  | `entity.bee.hurt`                              |
| `Bee Loop`                                  | `entity.bee.loop`                              |
| `Bee Loop (Aggressive)`                     | `entity.bee.loop_aggressive`                   |
| `Bee Pollinate`                             | `entity.bee.pollinate`                         |
| `Bee Sting`                                 | `entity.bee.sting`                             |
| `Cat Ambient`                               | `entity.cat.ambient`                           |
| `Cat Beg For Food`                          | `entity.cat.beg_for_food`                      |
| `Cat Death`                                 | `entity.cat.death`                             |
| `Cat Eat`                                   | `entity.cat.eat`                               |
| `Cat Hiss`                                  | `entity.cat.hiss`                              |
| `Cat Hurt`                                  | `entity.cat.hurt`                              |
| `Cat Purr`                                  | `entity.cat.purr`                              |
| `Cat Purreow`                               | `entity.cat.purreow`                           |
| `Stray Cat Ambient`                         | `entity.cat.stray_ambient`                     |
| `Chicken Ambient`                           | `entity.chicken.ambient`                       |
| `Chicken Death`                             | `entity.chicken.death`                         |
| `Chicken Hurt`                              | `entity.chicken.hurt`                          |
| `Chicken Lay Egg`                           | `entity.chicken.egg`                           |
| `Chicken Step`                              | `entity.chicken.step`                          |
| `Cow Ambient`                               | `entity.cow.ambient`                           |
| `Cow Death`                                 | `entity.cow.death`                             |
| `Cow Hurt`                                  | `entity.cow.hurt`                              |
| `Cow Milk`                                  | `entity.cow.milk`                              |
| `Cow Step`                                  | `entity.cow.step`                              |
| `Dolphin Ambient`                           | `entity.dolphin.ambient`                       |
| `Dolphin Ambient (Water)`                   | `entity.dolphin.ambient_water`                 |
| `Dolphin Attack`                            | `entity.dolphin.attack`                        |
| `Dolphin Death`                             | `entity.dolphin.death`                         |
| `Dolphin Eat`                               | `entity.dolphin.eat`                           |
| `Dolphin Hurt`                              | `entity.dolphin.hurt`                          |
| `Dolphin Jump`                              | `entity.dolphin.jump`                          |
| `Dolphin Play`                              | `entity.dolphin.play`                          |
| `Dolphin Splash`                            | `entity.dolphin.splash`                        |
| `Dolphin Swim`                              | `entity.dolphin.swim`                          |
| `Donkey Ambient`                            | `entity.donkey.ambient`                        |
| `Donkey Angry`                              | `entity.donkey.angry`                          |
| `Donkey Death`                              | `entity.donkey.death`                          |
| `Donkey Equip Chest`                        | `entity.donkey.chest`                          |
| `Donkey Hurt`                               | `entity.donkey.hurt`                           |
| `Fish Ambient`                              | `entity.cod.ambient`                           |
| `Fish Death`                                | `entity.cod.death`                             |
| `Fish Flop`                                 | `entity.cod.flop`                              |
| `Fish Hurt`                                 | `entity.cod.hurt`                              |
| `Fish Swim`                                 | `entity.fish.swim`                             |
| `Fox Aggravate`                             | `entity.fox.aggro`                             |
| `Fox Ambient`                               | `entity.fox.ambient`                           |
| `Fox Bite`                                  | `entity.fox.bite`                              |
| `Fox Death`                                 | `entity.fox.death`                             |
| `Fox Eat`                                   | `entity.fox.eat`                               |
| `Fox Hurt`                                  | `entity.fox.hurt`                              |
| `Fox Screech`                               | `entity.fox.screech`                           |
| `Fox Sleep`                                 | `entity.fox.sleep`                             |
| `Fox Sniff`                                 | `entity.fox.sniff`                             |
| `Fox Spit`                                  | `entity.fox.spit`                              |
| `Horse Ambient`                             | `entity.horse.ambient`                         |
| `Horse Angry`                               | `entity.horse.angry`                           |
| `Horse Breathe`                             | `entity.horse.breathe`                         |
| `Horse Death`                               | `entity.horse.death`                           |
| `Horse Eat`                                 | `entity.horse.eat`                             |
| `Horse Equip Saddle`                        | `entity.horse.saddle`                          |
| `Horse Equip Armor`                         | `entity.horse.armor`                           |
| `Horse Gallop`                              | `entity.horse.gallop`                          |
| `Horse Hurt`                                | `entity.horse.hurt`                            |
| `Horse Jump`                                | `entity.horse.jump`                            |
| `Horse Land`                                | `entity.horse.land`                            |
| `Horse Step`                                | `entity.horse.step`                            |
| `Horse Step (Wood)`                         | `entity.horse.step_wood`                       |
| `Iron Golem Attack`                         | `entity.iron_golem.attack`                     |
| `Iron Golem Death`                          | `entity.iron_golem.death`                      |
| `Iron Golem Hurt`                           | `entity.iron_golem.hurt`                       |
| `Iron Golem Step`                           | `entity.iron_golem.step`                       |
| `Llama Ambient`                             | `entity.llama.ambient`                         |
| `Llama Angry`                               | `entity.llama.angry`                           |
| `Llama Death`                               | `entity.llama.death`                           |
| `Llama Eat`                                 | `entity.llama.eat`                             |
| `Llama Equip Chest`                         | `entity.llama.chest`                           |
| `Llama Hurt`                                | `entity.llama.hurt`                            |
| `Llama Step`                                | `entity.llama.step`                            |
| `Llama Spit`                                | `entity.llama.spit`                            |
| `Llama Swag`                                | `entity.llama.swag`                            |
| `Mooshroom Convert`                         | `entity.mooshroom.convert`                     |
| `Mooshroom Eat`                             | `entity.mooshroom.eat`                         |
| `Mooshroom Milk`                            | `entity.mooshroom.milk`                        |
| `Mooshroom Shear`                           | `entity.mooshroom.shear`                       |
| `Brown Mooshroom Milk`                      | `entity.mooshroom.suspicious_milk`             |
| `Mule Equip Chest`                          | `entity.mule.chest`                            |
| `Mule Ambient`                              | `entity.mule.ambient`                          |
| `Mule Death`                                | `entity.mule.death`                            |
| `Mule Hurt`                                 | `entity.mule.hurt`                             |
| `Ocelot Ambient`                            | `entity.ocelot.ambient`                        |
| `Ocelot Death`                              | `entity.ocelot.death`                          |
| `Ocelot Hurt`                               | `entity.ocelot.hurt`                           |
| `Panda Ambient`                             | `entity.panda.ambient`                         |
| `Panda Ambient (Aggressive)`                | `entity.panda.aggressive_ambient`              |
| `Panda Ambient (Worried)`                   | `entity.panda.worried_ambient`                 |
| `Panda Bite`                                | `entity.panda.bite`                            |
| `Panda Sterile`                             | `entity.panda.cant_breed`                      |
| `Panda Death`                               | `entity.panda.death`                           |
| `Panda Eat`                                 | `entity.panda.eat`                             |
| `Panda Hurt`                                | `entity.panda.hurt`                            |
| `Panda Pre-Sneeze`                          | `entity.panda.pre_sneeze`                      |
| `Panda Sneeze`                              | `entity.panda.sneeze`                          |
| `Panda Step`                                | `entity.panda.step`                            |
| `Parrot Ambient`                            | `entity.parrot.ambient`                        |
| `Parrot Death`                              | `entity.parrot.death`                          |
| `Parrot Hurt`                               | `entity.parrot.hurt`                           |
| `Parrot Step`                               | `entity.parrot.step`                           |
| `Parrot Eat`                                | `entity.parrot.eat`                            |
| `Parrot Fly`                                | `entity.parrot.fly`                            |
| `Parrot Imitate Blaze`                      | `entity.parrot.imitate.blaze`                  |
| `Parrot Imitate Creeper`                    | `entity.parrot.imitate.creeper`                |
| `Parrot Imitate Drowned`                    | `entity.parrot.imitate.drowned`                |
| `Parrot Imitate Elder Guardian`             | `entity.parrot.imitate.elder_guardian`         |
| `Parrot Imitate Ender Dragon`               | `entity.parrot.imitate.ender_dragon`           |
| `Parrot Imitate Endermite`                  | `entity.parrot.imitate.endermite`              |
| `Parrot Imitate Evoker`                     | `entity.parrot.imitate.evoker`                 |
| `Parrot Imitate Ghast`                      | `entity.parrot.imitate.ghast`                  |
| `Parrot Imitate Guardian`                   | `entity.parrot.imitate.guardian`               |
| `Parrot Imitate Husk`                       | `entity.parrot.imitate.husk`                   |
| `Parrot Imitate Illusioner`                 | `entity.parrot.imitate.illusioner`             |
| `Parrot Imitate Magma Cube`                 | `entity.parrot.imitate.magma_cube`             |
| `Parrot Imitate Phantom`                    | `entity.parrot.imitate.phantom`                |
| `Parrot Imitate Pillager`                   | `entity.parrot.imitate.pillager`               |
| `Parrot Imitate Ravager`                    | `entity.parrot.imitate.ravager`                |
| `Parrot Imitate Shulker`                    | `entity.parrot.imitate.shulker`                |
| `Parrot Imitate Silverfish`                 | `entity.parrot.imitate.silverfish`             |
| `Parrot Imitate Skeleton`                   | `entity.parrot.imitate.skeleton`               |
| `Parrot Imitate Slime`                      | `entity.parrot.imitate.slime`                  |
| `Parrot Imitate Spider`                     | `entity.parrot.imitate.spider`                 |
| `Parrot Imitate Stray`                      | `entity.parrot.imitate.stray`                  |
| `Parrot Imitate Vex`                        | `entity.parrot.imitate.vex`                    |
| `Parrot Imitate Vindicator`                 | `entity.parrot.imitate.vindicator`             |
| `Parrot Imitate Witch`                      | `entity.parrot.imitate.witch`                  |
| `Parrot Imitate Wither`                     | `entity.parrot.imitate.wither`                 |
| `Parrot Imitate Wither Skeleton`            | `entity.parrot.imitate.wither_skeleton`        |
| `Parrot Imitate Zombie`                     | `entity.parrot.imitate.zombie`                 |
| `Parrot Imitate Zombie Villager`            | `entity.parrot.imitate.zombie_villager`        |
| `Pig Ambient`                               | `entity.pig.ambient`                           |
| `Pig Death`                                 | `entity.pig.death`                             |
| `Pig Equip Saddle`                          | `entity.pig.saddle`                            |
| `Pig Hurt`                                  | `entity.pig.hurt`                              |
| `Pig Step`                                  | `entity.pig.step`                              |
| `Polar Bear Ambient`                        | `entity.polar_bear.ambient`                    |
| `Polar Bear Death`                          | `entity.polar_bear.death`                      |
| `Polar Bear Hurt`                           | `entity.polar_bear.hurt`                       |
| `Polar Bear Step`                           | `entity.polar_bear.step`                       |
| `Polar Bear Warn`                           | `entity.polar_bear.warning`                    |
| `Baby Polar Bear Ambient`                   | `entity.polar_bear.ambient_baby`               |
| `Pufferfish Ambient`                        | `entity.puffer_fish.ambient`                   |
| `Pufferfish Death`                          | `entity.puffer_fish.death`                     |
| `Pufferfish Deflate`                        | `entity.puffer_fish.blow_out`                  |
| `Pufferfish Flop`                           | `entity.puffer_fish.flop`                      |
| `Pufferfish Hurt`                           | `entity.puffer_fish.hurt`                      |
| `Pufferfish Inflate`                        | `entity.puffer_fish.blow_up`                   |
| `Pufferfish Sting`                          | `entity.puffer_fish.sting`                     |
| `Rabbit Ambient`                            | `entity.rabbit.ambient`                        |
| `Rabbit Death`                              | `entity.rabbit.death`                          |
| `Rabbit Hurt`                               | `entity.rabbit.hurt`                           |
| `Rabbit Jump`                               | `entity.rabbit.jump`                           |
| `Killer Rabbit Attack`                      | `entity.rabbit.attack`                         |
| `Sheep Ambient`                             | `entity.sheep.ambient`                         |
| `Sheep Death`                               | `entity.sheep.death`                           |
| `Sheep Hurt`                                | `entity.sheep.hurt`                            |
| `Sheep Shear`                               | `entity.sheep.shear`                           |
| `Sheep Step`                                | `entity.sheep.step`                            |
| `Snow Golem Ambient`                        | `entity.snow_golem.ambient`                    |
| `Snow Golem Death`                          | `entity.snow_golem.death`                      |
| `Snow Golem Hurt`                           | `entity.snow_golem.hurt`                       |
| `Snow Golem Shoot`                          | `entity.snow_golem.shoot`                      |
| `Squid Ambient`                             | `entity.squid.ambient`                         |
| `Squid Death`                               | `entity.squid.death`                           |
| `Squid Hurt`                                | `entity.squid.hurt`                            |
| `Squid Squirt`                              | `entity.squid.squirt`                          |
| `Turtle Ambient`                            | `entity.turtle.ambient_land`                   |
| `Turtle Death`                              | `entity.turtle.death`                          |
| `Turtle Hurt`                               | `entity.turtle.hurt`                           |
| `Turtle Shamble`                            | `entity.turtle.shamble`                        |
| `Turtle Lay Egg`                            | `entity.turtle.lay_egg`                        |
| `Turtle Egg Crack`                          | `entity.turtle.egg_crack`                      |
| `Turtle Egg Hatch`                          | `entity.turtle.egg_hatch`                      |
| `Turtle Egg Break`                          | `entity.turtle.egg_break`                      |
| `Turtle Swim`                               | `entity.turtle.swim`                           |
| `Baby Turtle Death`                         | `entity.turtle.death_baby`                     |
| `Baby Turtle Hurt`                          | `entity.turtle.hurt_baby`                      |
| `Baby Turtle Shamble`                       | `entity.turtle.shamble_baby`                   |
| `Villager Ambient`                          | `entity.villager.ambient`                      |
| `Villager Death`                            | `entity.villager.death`                        |
| `Villager Hurt`                             | `entity.villager.hurt`                         |
| `Villager No`                               | `entity.villager.no`                           |
| `Villager Trading`                          | `entity.villager.trade`                        |
| `Villager Yes`                              | `entity.villager.yes`                          |
| `Armorer Work`                              | `entity.villager.work_armorer`                 |
| `Butcher Work`                              | `entity.villager.work_butcher`                 |
| `Cartographer Work`                         | `entity.villager.work_cartographer`            |
| `Cleric Work`                               | `entity.villager.work_cleric`                  |
| `Farmer Work`                               | `entity.villager.work_farmer`                  |
| `Fisherman Work`                            | `entity.villager.work_fisherman`               |
| `Fletcher Work`                             | `entity.villager.work_fletcher`                |
| `Leatherworker Work`                        | `entity.villager.work_leatherworker`           |
| `Librarian Work`                            | `entity.villager.work_librarian`               |
| `Mason Work`                                | `entity.villager.work_mason`                   |
| `Shepherd Work`                             | `entity.villager.work_shepherd`                |
| `Toolsmith Work`                            | `entity.villager.work_toolsmith`               |
| `Weaponsmith Work`                          | `entity.villager.work_weaponsmith`             |
| `Villager Celebrate`                        | `entity.villager.celebrate`                    |
| `Wandering Trader Ambient`                  | `entity.wandering_trader.ambient`              |
| `Wandering Trader Death`                    | `entity.wandering_trader.death`                |
| `Wandering Trader Disappear`                | `entity.wandering_trader.disappeared`          |
| `Wandering Trader Drink Milk`               | `entity.wandering_trader.drink_milk`           |
| `Wandering Trader Drink Potion`             | `entity.wandering_trader.drink_potion`         |
| `Wandering Trader Hurt`                     | `entity.wandering_trader.hurt`                 |
| `Wandering Trader No`                       | `entity.wandering_trader.no`                   |
| `Wandering Trader Reappear`                 | `entity.wandering_trader.reappeared`           |
| `Wandering Trader Trading`                  | `entity.wandering_trader.trade`                |
| `Wandering Trader Yes`                      | `entity.wandering_trader.yes`                  |
| `Wolf Ambient`                              | `entity.wolf.ambient`                          |
| `Wolf Death`                                | `entity.wolf.death`                            |
| `Wolf Growl`                                | `entity.wolf.growl`                            |
| `Wolf Howl`                                 | `entity.wolf.howl`                             |
| `Wolf Hurt`                                 | `entity.wolf.hurt`                             |
| `Wolf Pant`                                 | `entity.wolf.pant`                             |
| `Wolf Shake`                                | `entity.wolf.shake`                            |
| `Wolf Step`                                 | `entity.wolf.step`                             |
| `Wolf Whine`                                | `entity.wolf.whine`                            |
| `Blaze Ambient`                             | `entity.blaze.ambient`                         |
| `Blaze Burn`                                | `entity.blaze.burn`                            |
| `Blaze Death`                               | `entity.blaze.death`                           |
| `Blaze Hurt`                                | `entity.blaze.hurt`                            |
| `Blaze Shoot`                               | `entity.blaze.shoot`                           |
| `Creeper Death`                             | `entity.creeper.death`                         |
| `Explode`                                   | `entity.generic.explode`                       |
| `Creeper Hurt`                              | `entity.creeper.hurt`                          |
| `Creeper Primed`                            | `entity.creeper.primed`                        |
| `Drowned Ambient`                           | `entity.drowned.ambient_water`                 |
| `Drowned Ambient (Land)`                    | `entity.drowned.ambient`                       |
| `Drowned Death`                             | `entity.drowned.death_water`                   |
| `Drowned Death (Land)`                      | `entity.drowned.death`                         |
| `Drowned Hurt`                              | `entity.drowned.hurt_water`                    |
| `Drowned Hurt (Land)`                       | `entity.drowned.hurt`                          |
| `Drowned Shoot`                             | `entity.drowned.shoot`                         |
| `Drowned Step`                              | `entity.drowned.step`                          |
| `Drowned Swim`                              | `entity.drowned.swim`                          |
| `Elder Guardian Ambient`                    | `entity.elder_guardian.ambient`                |
| `Elder Guardian Ambient (Land)`             | `entity.elder_guardian.ambient_land`           |
| `Elder Guardian Curse`                      | `entity.elder_guardian.curse`                  |
| `Elder Guardian Death`                      | `entity.elder_guardian.death`                  |
| `Elder Guardian Death (Land)`               | `entity.elder_guardian.death_land`             |
| `Elder Guardian Flop`                       | `entity.elder_guardian.flop`                   |
| `Elder Guardian Hurt`                       | `entity.elder_guardian.hurt`                   |
| `Elder Guardian Hurt (Land)`                | `entity.elder_guardian.hurt_land`              |
| `Ender Dragon Ambient`                      | `entity.ender_dragon.ambient`                  |
| `Ender Dragon Death`                        | `entity.ender_dragon.death`                    |
| `Ender Dragon Hurt`                         | `entity.ender_dragon.hurt`                     |
| `Ender Dragon Fireball Explode`             | `entity.dragon_fireball.explode`               |
| `Ender Dragon Flap`                         | `entity.ender_dragon.flap`                     |
| `Ender Dragon Growl`                        | `entity.ender_dragon.growl`                    |
| `Ender Dragon Shoot`                        | `entity.ender_dragon.shoot`                    |
| `Enderman Ambient`                          | `entity.enderman.ambient`                      |
| `Enderman Death`                            | `entity.enderman.death`                        |
| `Enderman Hurt`                             | `entity.enderman.hurt`                         |
| `Enderman Scream`                           | `entity.enderman.scream`                       |
| `Enderman Stare`                            | `entity.enderman.stare`                        |
| `Enderman Teleport`                         | `entity.enderman.teleport`                     |
| `Endermite Ambient`                         | `entity.endermite.ambient`                     |
| `Endermite Death`                           | `entity.endermite.death`                       |
| `Endermite Hurt`                            | `entity.endermite.hurt`                        |
| `Endermite Step`                            | `entity.endermite.step`                        |
| `Evoker Ambient`                            | `entity.evoker.ambient`                        |
| `Evoker Cast Spell`                         | `entity.evoker.cast_spell`                     |
| `Evoker Death`                              | `entity.evoker.death`                          |
| `Evoker Hurt`                               | `entity.evoker.hurt`                           |
| `Evoker Prepare Attack`                     | `entity.evoker.prepare_attack`                 |
| `Evoker Prepare Summon`                     | `entity.evoker.prepare_summon`                 |
| `Evoker Prepare Wololo`                     | `entity.evoker.prepare_wololo`                 |
| `Evoker Fangs Attack`                       | `entity.evoker_fangs.attack`                   |
| `Evoker Celebrate`                          | `entity.evoker.celebrate`                      |
| `Ghast Ambient`                             | `entity.ghast.ambient`                         |
| `Ghast Death`                               | `entity.ghast.death`                           |
| `Ghast Hurt`                                | `entity.ghast.hurt`                            |
| `Ghast Scream`                              | `entity.ghast.scream`                          |
| `Ghast Shoot`                               | `entity.ghast.shoot`                           |
| `Ghast Warn`                                | `entity.ghast.warn`                            |
| `Guardian Ambient`                          | `entity.guardian.ambient`                      |
| `Guardian Ambient (Land)`                   | `entity.guardian.ambient_land`                 |
| `Guardian Attack`                           | `entity.guardian.attack`                       |
| `Guardian Death`                            | `entity.guardian.death`                        |
| `Guardian Death (Land)`                     | `entity.guardian.death_land`                   |
| `Guardian Flop`                             | `entity.guardian.flop`                         |
| `Guardian Hurt`                             | `entity.guardian.hurt`                         |
| `Guardian Hurt (Land)`                      | `entity.guardian.hurt_land`                    |
| `Husk Ambient`                              | `entity.husk.ambient`                          |
| `Husk Death`                                | `entity.husk.death`                            |
| `Husk Hurt`                                 | `entity.husk.hurt`                             |
| `Husk Step`                                 | `entity.husk.step`                             |
| `Husk Drown`                                | `entity.husk.converted_to_zombie`              |
| `Illusioner Ambient`                        | `entity.illusioner.ambient`                    |
| `Illusioner Death`                          | `entity.illusioner.death`                      |
| `Illusioner Hurt`                           | `entity.illusioner.hurt`                       |
| `Illusioner Cast Spell`                     | `entity.illusioner.cast_spell`                 |
| `Illusioner Mirror Move`                    | `entity.illusioner.mirror_move`                |
| `Illusioner Prepare Blindness`              | `entity.illusioner.prepare_blindness`          |
| `Illusioner Prepare Mirror`                 | `entity.illusioner.prepare_mirror`             |
| `Magma Cube Death`                          | `entity.magma_cube.death`                      |
| `Magma Cube Hurt`                           | `entity.magma_cube.hurt`                       |
| `Magma Cube Jump`                           | `entity.magma_cube.jump`                       |
| `Magma Cube Squish`                         | `entity.magma_cube.squish`                     |
| `Small Magma Cube Death`                    | `entity.magma_cube.death_small`                |
| `Small Magma Cube Hurt`                     | `entity.magma_cube.hurt_small`                 |
| `Small Magma Cube Squish`                   | `entity.magma_cube.squish_small`               |
| `Pillager Ambient`                          | `entity.pillager.ambient`                      |
| `Pillager Death`                            | `entity.pillager.death`                        |
| `Pillager Hurt`                             | `entity.pillager.hurt`                         |
| `Pillager Celebrate`                        | `entity.pillager.celebrate`                    |
| `Phantom Ambient`                           | `entity.phantom.ambient`                       |
| `Phantom Bite`                              | `entity.phantom.bite`                          |
| `Phantom Death`                             | `entity.phantom.death`                         |
| `Phantom Flap`                              | `entity.phantom.flap`                          |
| `Phantom Hurt`                              | `entity.phantom.hurt`                          |
| `Phantom Swoop`                             | `entity.phantom.swoop`                         |
| `Ravager Ambient`                           | `entity.ravager.ambient`                       |
| `Ravager Attack`                            | `entity.ravager.attack`                        |
| `Ravager Death`                             | `entity.ravager.death`                         |
| `Ravager Hurt`                              | `entity.ravager.hurt`                          |
| `Ravager Roar`                              | `entity.ravager.roar`                          |
| `Ravager Step`                              | `entity.ravager.step`                          |
| `Ravager Stunned`                           | `entity.ravager.stunned`                       |
| `Ravager Celebrate`                         | `entity.ravager.celebrate`                     |
| `Shulker Ambient`                           | `entity.shulker.ambient`                       |
| `Shulker Close`                             | `entity.shulker.close`                         |
| `Shulker Death`                             | `entity.shulker.death`                         |
| `Shulker Hurt`                              | `entity.shulker.hurt`                          |
| `Shulker Hurt (Closed)`                     | `entity.shulker.hurt_closed`                   |
| `Shulker Open`                              | `entity.shulker.open`                          |
| `Shulker Shoot`                             | `entity.shulker.shoot`                         |
| `Shulker Teleport`                          | `entity.shulker.teleport`                      |
| `Shulker Bullet Explode`                    | `entity.shulker_bullet.hit`                    |
| `Shulker Bullet Break`                      | `entity.shulker_bullet.hurt`                   |
| `Silverfish Ambient`                        | `entity.silverfish.ambient`                    |
| `Silverfish Death`                          | `entity.silverfish.death`                      |
| `Silverfish Hurt`                           | `entity.silverfish.hurt`                       |
| `Silverfish Step`                           | `entity.silverfish.step`                       |
| `Skeleton Ambient`                          | `entity.skeleton.ambient`                      |
| `Skeleton Death`                            | `entity.skeleton.death`                        |
| `Skeleton Hurt`                             | `entity.skeleton.hurt`                         |
| `Skeleton Step`                             | `entity.skeleton.step`                         |
| `Skeleton Shoot`                            | `entity.skeleton.shoot`                        |
| `Slime Attack`                              | `entity.slime.attack`                          |
| `Slime Death`                               | `entity.slime.death`                           |
| `Slime Hurt`                                | `entity.slime.hurt`                            |
| `Slime Jump`                                | `entity.slime.jump`                            |
| `Slime Squish`                              | `entity.slime.squish`                          |
| `Small Slime Death`                         | `entity.slime.death_small`                     |
| `Small Slime Hurt`                          | `entity.slime.hurt_small`                      |
| `Small Slime Jump`                          | `entity.slime.jump_small`                      |
| `Small Slime Squish`                        | `entity.slime.squish_small`                    |
| `Spider Ambient`                            | `entity.spider.ambient`                        |
| `Spider Death`                              | `entity.spider.death`                          |
| `Spider Hurt`                               | `entity.spider.hurt`                           |
| `Spider Step`                               | `entity.spider.step`                           |
| `Stray Ambient`                             | `entity.stray.ambient`                         |
| `Stray Death`                               | `entity.stray.death`                           |
| `Stray Hurt`                                | `entity.stray.hurt`                            |
| `Stray Step`                                | `entity.stray.step`                            |
| `Skeleton Horse Ambient`                    | `entity.skeleton_horse.ambient`                |
| `Skeleton Horse Ambient (Water)`            | `entity.skeleton_horse.ambient_water`          |
| `Skeleton Horse Death`                      | `entity.skeleton_horse.death`                  |
| `Skeleton Horse Gallop (Water)`             | `entity.skeleton_horse.gallop_water`           |
| `Skeleton Horse Hurt`                       | `entity.skeleton_horse.hurt`                   |
| `Skeleton Horse Jump (Water)`               | `entity.skeleton_horse.jump_water`             |
| `Skeleton Horse Step (Water)`               | `entity.skeleton_horse.step_water`             |
| `Skeleton Horse Swim`                       | `entity.skeleton_horse.swim`                   |
| `Zombie Horse Ambient`                      | `entity.zombie_horse.ambient`                  |
| `Zombie Horse Death`                        | `entity.zombie_horse.death`                    |
| `Zombie Horse Hurt`                         | `entity.zombie_horse.hurt`                     |
| `Vex Ambient`                               | `entity.vex.ambient`                           |
| `Vex Charge`                                | `entity.vex.charge`                            |
| `Vex Death`                                 | `entity.vex.death`                             |
| `Vex Hurt`                                  | `entity.vex.hurt`                              |
| `Vindicator Ambient`                        | `entity.vindicator.ambient`                    |
| `Vindicator Death`                          | `entity.vindicator.death`                      |
| `Vindicator Hurt`                           | `entity.vindicator.hurt`                       |
| `Vindicator Celebrate`                      | `entity.vindicator.celebrate`                  |
| `Witch Ambient`                             | `entity.witch.ambient`                         |
| `Witch Death`                               | `entity.witch.death`                           |
| `Witch Drink`                               | `entity.witch.drink`                           |
| `Witch Hurt`                                | `entity.witch.hurt`                            |
| `Witch Throw`                               | `entity.witch.throw`                           |
| `Witch Celebrate`                           | `entity.witch.celebrate`                       |
</details>

### Relative locations

| Data        | Description                                   | Type                            |
|-------------|-----------------------------------------------|---------------------------------|
| `target`    | The Target of the Location (Default: Default) | Target                          |
| `forward`   | The Forward Location offset                   | Double                          |
| `up`        | The Up Location offset                        | Double                          |
| `right`     | The Right Location offset                     | Double                          |
| `rot_down`  | The Rotational Down Location offset           | Double                          |
| `rot_right` | The Rotational Right Location offset          | Double                          |

### Particles

| Data       | Description                                    | Type                            |
|------------|------------------------------------------------|---------------------------------|
| `particle` | The Id of the particle                         | Particle type, see below        |
| `cluster`  | More Data for how the particle should function | [Cluster Object](#ClusterObject)|

*Particles have Two "data" areas*

| Data              | Description                                         | Type    |
|-------------------|-----------------------------------------------------|---------|
| `x`               | The X coordinate offset (Default: 1.0)              | Double  |
| `y`               | The Y coordinate offset                             | Double  |
| `z`               | The Z coordinate offset                             | Double  |
| `motionvariation` | The Motion Variation of the particle (Default: 100) | Integer |

<details>
<summary>Particle types</summary>
| Name                    | Minecraft ID            |
|-------------------------|-------------------------|
| `Smoke`                 | `smoke`                 |
| `Large Smoke`           | `large_smoke`           |
| `Flame`                 | `flame`                 |
| `Angry Villager`        | `angry_villager`        |
| `Happy Villager`        | `happy_villager`        |
| `Heart`                 | `heart`                 |
| `Note`                  | `note`                  |
| `Firework`              | `firework`              |
| `Barrier`               | `barrier`               |
| `Poof`                  | `poof`                  |
| `Explosion`             | `explosion`             |
| `Explosion Emitter`     | `explosion_emitter`     |
| `Lava`                  | `lava`                  |
| `Splash`                | `splash`                |
| `Dripping Lava`         | `dripping_lava`         |
| `Dripping Water`        | `dripping_water`        |
| `Dragon Breath`         | `dragon_breath`         |
| `Slime`                 | `item_slime`            |
| `Portal`                | `portal`                |
| `Enchant`               | `enchant`               |
| `Redstone`              | `dust`                  |
| `Critical Hit`          | `crit`                  |
| `Enchanted Hit`         | `enchanted_hit`         |
| `Damage Indicator`      | `damage_indicator`      |
| `Cloud`                 | `cloud`                 |
| `Spit`                  | `spit`                  |
| `Totem of Undying`      | `totem_of_undying`      |
| `Witch`                 | `witch`                 |
| `Mob Spell`             | `effect`                |
| `Mycelium`              | `mycelium`              |
| `Bubble`                | `bubble`                |
| `Bubble Pop`            | `bubble_pop`            |
| `Dolphin`               | `dolphin`               |
| `Elder Guardian`        | `elder_guardian`        |
| `End Rod`               | `end_rod`               |
| `Snowball`              | `item_snowball`         |
| `Nautilus`              | `nautilus`              |
| `Sweep Attack`          | `sweep_attack`          |
| `Squid Ink`             | `squid_ink`             |
| `Fishing`               | `fishing`               |
| `Sneeze`                | `sneeze`                |
| `Whirlpool Bubble`      | `current_down`          |
| `Column Bubble`         | `bubble_column_up`      |
| `Campfire Smoke`        | `campfire_cosy_smoke`   |
| `Campfire Signal Smoke` | `campfire_signal_smoke` |
</details>


#### ClusterObject

| Field name   | Description               | Type     |
|--------------|---------------------------|----------|
| `amount`     | The Amount (Default: 1)   | Integer  |
| `horizontal` | The Horizontal axis       | Double   |
| `verticle`   | The Verticle axis         | Double   |

### Potions

| Data     | Description                                       | Type                           |
|----------|---------------------------------------------------|--------------------------------|
| `pot`    | The Id of the effect                              | Effect                         |
| `dur`    | The Duration of the effect                        | Integer                        |
| `amp`    | The Amplifier of the effect                       | Integer                        |
### Variables

| Data     | Description                                  | Type                               |
|----------|----------------------------------------------|------------------------------------|
| `name`   | The Name of the variable                     | String                             |
| `scope`  | The Scope of the variable                    | [Variable Scopes](#VariableScopes) |

#### VariableScopes

Hypercube has 3 Variable Scopes These are
- Unsaved `unsaved` *Known as GAME*
- Saved `saved`
- Local `local`

### GameValues

| Data        | Description                                   | Type                            |
|-------------|-----------------------------------------------|---------------------------------|
| `type`      | The Type of Game Value                        | Game Value Type (PLS MAKE)      |
| `target`    | The Target of the Game Value                  | Target                          |

### Vectors

| Data        | Description                                   | Type                            |
|-------------|-----------------------------------------------|---------------------------------|
| `x`         | The X coordinate                              | Double                          |
| `y`         | The Y coordinate                              | Double                          |
| `z`         | The Z coordinate                              | Double                          |


### Targets
