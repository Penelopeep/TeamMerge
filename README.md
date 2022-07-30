# TeamMerge plugin
### Allows you to quickly make massive teams just by setting them as other party 


https://user-images.githubusercontent.com/81880849/181936815-bb72f3b6-d05f-40a0-a020-64f204ba98ba.mp4


## Usage:
1. Make sure that your server support more than 4 character parties (you can set in config.json in main folder of grasscutter)
   <br>You must change value of: **server>game>gameOptions>avatarLimits>singlePlayerTeam**
2. Make party that you want in normal party slots (you can use all 4 teams, party order matters)
3. Use /tm or /party in on in-game chat with server (or without "/" in console)

**Optional:**
Is you want to change something in current big party then go to party setup and click on quick setup, it should allow you to change characters and their order just by clicking on both of them and clicking them in reverse order.

## FAQ

1. How to install plugin?
    - Add the newest jar file from [here](https://github.com/Penelopeep/TeamMerge/releases), and put it in **GrasscutterFolder/Plugins** (make one if you don't have)
2. I can't find this config value
   - Just open **config.json** press **ctrl+f** and search for **singlePlayerTeam**
3. Plugin told me to go to README:<br>
   - _Your game doesn't allow for party larger than 4 party members, go and change that in **config.json** in your grasscutter folder_
4. After changing config.json I still can't make bigger parties
   - Dm me on discord **Penelopeep#7963** since in this case it will be probably error which don't occur on my pc.
5. Just use /team add
   - I'm lazy and I thought it's cooler, also it's easier because /team requires avatarId but plugin just takes it from game
6. Your error handling sucks
   - You're right, if you know how to make proper error handling or how to get data from **config.json** then make pull request or dm me on discord **Penelopeep#7963**

## Credits:

- Grasscutter team for making PluginTemplate and Grasscutter itself
- Me for everything else
