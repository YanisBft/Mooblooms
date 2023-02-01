# Mooblooms

Mooblooms is a mod inspired by Minecraft Earth game, adding colorful and flowery cows.
Made using Fabric API.

[![](http://cf.way2muchnoise.eu/full_mooblooms_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/mooblooms)
[![](http://cf.way2muchnoise.eu/versions/minecraft_mooblooms_all.svg)](https://www.curseforge.com/minecraft/mc-mods/mooblooms)
[![](https://img.shields.io/github/v/tag/YanisBft/Mooblooms?label=version)](https://www.curseforge.com/minecraft/mc-mods/mooblooms)
[![](https://img.shields.io/github/license/YanisBft/Mooblooms.svg)](LICENSE)

---

## API
Since 1.3.0, Mooblooms provides builders to easily add mooblooms and cluckshrooms to your mod.

#### Adding Mooblooms to your project
You can use Mooblooms as a library for your gradle project. Add the following in your ``build.gradle``:
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    modCompile "com.github.YanisBft:Mooblooms:${mooblooms_version}"
}
```
Then, add the version in your ``gradle.properties``:
```properties
mooblooms_version = 1.5.0
```

#### Available settings
* ``name(Identifier name)`` (**required**)
* ``blockState(BlockState state)`` (**required**)
* ``blockStateRenderer(float scaleX, float scaleY, float scaleZ, double translationX, double translationY, double translationZ)``
* ``blockStateRenderer(Vec3f scale, Vec3d translation)``
* ``fireImmune()``
* ``validBlocks(BlockGags blocks)``
* ``validBlocks(List<Block> blocks)``
* ``cannotPlaceBlocks()``
* ``ignoredEffects(List<StatusEffect> effects)``
* ``ignoredDamageSources(List<DamageSource> damageSources)``
* ``particle(ParticleEffect particle)``
* ``lootTable(Identifier lootTable)``
* ``spawnEntry(SpawnEntry spawnEntry)``
* ``spawnEgg(int primaryColor, int secondaryColor)``
* ``spawnEgg(int primaryColor, int secondaryColor, ItemGroup group)``
* ``configCategory(MoobloomConfigCategory configCategory)``

#### What you need to do
Some things still need to be done outside the builders:
* Make the texture file of your entity
* Create the model file of your spawn egg
* Add spawn restriction settings
* Add a config for your entity

*Note that some of these are planned to be added to the builders in the future.*
