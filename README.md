# Mooblooms

Mooblooms is a mod inspired by Minecraft Earth game, adding colorful and flowery cows.
Made using Fabric API.

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
mooblooms_version = 1.4.0
```

#### Available settings
* ``name(Identifier name)`` (**required**)
* ``fireImmune()``
* ``blockState(BlockState state)`` (**required**)
* ``validBlocks(Tag<Block> blocks)``
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
