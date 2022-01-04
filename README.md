# Underwater Rails

![](https://github.com/Hennamann/Underwater-Rails/blob/1.18.1/src/main/resources/underwaterrails.png?raw=true)

This mod was originally made for Modjam 5 (2018.1) but has since been updated!


It adds 2 new rails to the game:

- Basic Underwater Rail (Can be placed underwater, but does not stop the player from drowning) 
- Advanced Underwater Rail (Can also be placed underwater and it stops the player from drowning while in a minecart on the rail, as well as disabling the underwater fog)

**NOTE**: In 1.18.1 there is only advanced underwater rails (named just Underwater rails), this is due to vanilla rails now being placable under water in 1.18.1.

These all come in 4 variants,

The standard rails
Powered rails
Detector rails
Activator rails
 
Currently the only supported MC versions are 1.16.5 and 1.18.1, with 1.18.1 taking priority over 1.16.5.

the 1.12 version is unlikely to get further updates!

For more info and downloads see the curseforge page for the mod:
https://www.curseforge.com/minecraft/mc-mods/underwater-rails

## Known issues

- Advanced underwater rails are currently only modeled for standard and curved orientations, meaning that when used in a slope the default raised rail minecraft model is used(still functions as an underwater rail though), i hope to get this fixed but i am held back by my lackluster modeling skills, help is appreciated here!
- Underwater rails sometimes do not render properly underwater, this seems to be a vanilla issue that was fixed/improved with 1.17/1.18. So it is unlikeley to be fixed.

## API
There is a basic API in the mod allowing other mods to define their rails as underwater rails, specifically the advanced variant. Use the Javadoc along with the src code for usage. The API is found in the IUnderwaterRail interface class.

NOTE: Whilst there is no maven or deobf/src builds yet i do plan on getting this available soon.

## License
The mod is licensed under the MIT License. See LICENSE.MD for details on the license.

This means you are free to use the mod in your modpack or whatever, no need to ask me, in fact i am likely to just ignore you if you ask
