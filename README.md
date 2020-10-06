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
mooblooms_version = 1.3.2
```

#### Available settings
* ``name(Identifier name)`` (**required**)
* ``fireImmune()``
* ``blockState(BlockState state)`` (**required**)
* ``validBlocks(Tag<Block> blocks)``
* ``validBlocks(List<Block> blocks)``
* ``cannotPlaceBlocks()``
* ``ignoredEffects(List<StatusEffect> effects)``
* ``particle(ParticleEffect particle)``
* ``spawnEgg(int primaryColor, int secondaryColor)``
* ``spawnEgg(int primaryColor, int secondaryColor, ItemGroup group)``
* ``configClass(Class<?> configClass)``

#### What you need to do
Some things still need to be done manually:
* Make the texture file of your entity
* Create the model file of your spawn egg
* Add your entity to the spawn list of one or more biomes
* Add spawn restriction settings
* Add a config for your entity

*Note that some of these are planned to be added to the builders in the future.*
