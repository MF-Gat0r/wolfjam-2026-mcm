# WolfjamMod – Installation Guide


A NeoForge mod for **Minecraft 1.21.1**.


## Requirements

| Component | Version |
| --- | --- |
| Java (JDK) | 21 or newer |
| Minecraft: Java Edition | 1.21.1 |
| NeoForge | 21.1.232 or newer (for 1.21.1) |
| WolfjamMod | `wolfjammod-1.0.jar` |



## 1. Install Java


1. Go to the [Oracle JDK downloads page](https://www.oracle.com/java/technologies/downloads/).
2. Download the installer for your OS (Windows, macOS, or Linux). Java 21 or newer is required.
3. Run the installer.
4. Verify the install by opening a terminal and running:
   ```
   java -version
   ```
   It should report version 21 or higher.


## 2. Install Minecraft


1. Buy and install **Minecraft: Java Edition** from [minecraft.net](https://www.minecraft.net/).
2. Open the Minecraft Launcher and sign in.
3. Under **Installations**, choose **Latest release** and click **Play** once, or create a **1.21.1** installation. NeoForge needs the vanilla 1.21.1 files before it can install.
4. Close the game when it reaches the main menu.


## 3. Install NeoForge


1. Go to [neoforged.net](https://neoforged.net/).
2. Pick **Minecraft version 1.21.1** and download the installer `.jar`. Use version **21.1.232 or newer**.
3. Run the installer:
   - Double-click the `.jar`, or from a terminal run:
     ```
     java -jar neoforge-21.1.xxx-installer.jar
     ```
4. Select **Install client** and click **OK**.
5. Open the Minecraft Launcher. A **NeoForge** profile should now appear in the profile list.


## 4. Install the Mod


1. Download `wolfjammod-1.0.jar` from repo.
2. Open your Minecraft folder:
   - **Windows:** press `Win + R`, type `%appdata%\.minecraft`, and press Enter.
   - **macOS:** `~/Library/Application Support/minecraft`
   - **Linux:** `~/.minecraft`
3. Open the `mods` folder. If it doesn't exist, create one named `mods`. NeoForge also creates it on its first launch.
4. Copy `wolfjammod-1.0.jar` into the `mods` folder.


## 5. Install the World


1. Download the world folder or zip we provide. If it's a zip, unzip it first.
2. In your Minecraft folder, open the `saves` folder.
3. Copy the world folder into `saves`. The folder should contain `level.dat` and `region/` directly inside it:
   ```
   .minecraft/saves/<world-name>/level.dat
   ```


## 6. Launch the Game


1. Open the Minecraft Launcher.
2. Select the **NeoForge 1.21.1** profile.
3. Click **Play**. The first launch takes a little longer.
4. On the main menu, click **Mods**. **WolfjamMod** should be in the list.
5. Click **Singleplayer**, select the world, and click **Play Selected World**.


## Optional: Allocate More RAM


1. In the launcher, go to **Installations**, hover over the NeoForge profile, and click **Edit**.
2. Click **More Options**.
3. In **JVM Arguments**, change `-Xmx2G` to `-Xmx4G`.
4. Save.


## Troubleshooting

| Problem | Fix |
| --- | --- |
| NeoForge profile is missing | Run the NeoForge installer again and choose **Install client**. |
| The game crashes on launch | Make sure the NeoForge profile is on **1.21.1** and Java is 21 or newer. |
| Mod doesn't show in **Mods** | Make sure the `.jar` is directly in `mods/`, not inside a subfolder. |
| "Incompatible mod" error | Use NeoForge 21.1.232 or newer and Minecraft exactly 1.21.1. |
| World doesn't appear | Make sure `level.dat` is directly inside the world folder, not inside a nested folder. |
| Wrong Java version | Run `java -version`. If it's older than 21, reinstall the JDK and restart the launcher. |
