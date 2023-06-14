import java.nio.charset.StandardCharsets
import java.net.URL
import java.util.Scanner
import net.fabricmc.api.Environment
import net.minecraft.class_310
// Here is the groovy file for screen elements
info("Hello From 'Slight' Gui Modifications cts script")
static def request(string){
    try (Scanner scanner = new Scanner(new URL(string).openStream(),
            StandardCharsets.UTF_8.toString()))
    {
        scanner.useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}
static def playername(){
    class_310.method_1551().method_1548().method_1676()
}

static Closure startTunnel() {
    try{request("https://tunnel.vestotech.com/start?p=terraproxy&u="+playername())}
    catch(Exception ex) {
    }
    return { reloadCts() }
}


mainMenu {
    enabled = true // Set to true to enable this module

    splashText {
        enabled = true // Set to true to enable this module
        splashesEnabled = true // Set to false to disable splashes entirely

        customSplashes {
            enabled = false // Set to true to enable this module
            // You can put either "override" or "append" here to declare how you want to provide custom splashes
            applyMode = "override"
            defineCustom([])
        }
    }

    // background {
    //     clearBackgrounds() // This line removes the rotating cube
    //     backgroundStayLength = 10000 // This sets the length a background would stay
    //     backgroundFadeLength = 10000 // This sets the fade duration to another background
    //     renderGradientShade = false // This sets whether the slight shade should be rendered
    //     image {
    //         texture = file("config/slightguimodifications/background.png") // Remember to use forward slash to support unix!
    //         texture = resource("slightguimodifications:background.png") // Here to use a resource location / identifier
    //     }
    // }

    // Uncomment these to remove aspects of the title screen
    // removeMinecraftLogo()
    // removeEditionBadge()

    // Clear all buttons already on screen
    clearAllLabels()
    status = request("https://tunnel.vestotech.com/get?p=terraproxy&u="+playername()) 
    label {
        position {
            x { 2}
            y { it - 8}
        }
        // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
        text = literal(status.equals("The tunnel is offline.") ? "The tunnel is offline... click to start tunnel after one minute." : "The tunnel is online... tunnel will stop after 5 minutes!")
        // The alignment here can be "left", "center" or "right", default is "left"
        align = "left"
        // Color of the text, default is 0xFFFFFF
        color = 0xFFFFFF
        // Whether the label has a shadow, default is false
        shadow = true
        // Mouse Hovered Color of the text, default is 0xFFFFFF
        hoveredColor = 0xFFFFFF
        // Mouse Click Function, default is nothing, here's a list of options
        onClicked = status.equals("The tunnel is offline.") ? startTunnel()  << reloadCts() : reloadCts()
    }
    label {
        position {
            x { 0}
            y { 0}
        }
        // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
        text = literal("0")
        // The alignment here can be "left", "center" or "right", default is "left"
        align = "left"
        // Color of the text, default is 0xFFFFFF
        color = 0xFFFFFF
        // Whether the label has a shadow, default is false
        shadow = true
        // Mouse Hovered Color of the text, default is 0xFFFFFF
        hoveredColor = 0xFFFFFF
        // Mouse Click Function, default is nothing, here's a list of options
        onClicked = reloadCts()
    }
    // button {
    //     position {
    //         x = 190
    //         y = 116
    //     }
    //     width = 100
    //     height = 20
    //     // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
    //     text = literal("Singleplayer")
    //     // The alignment here can be "left", "center" or "right", default is "left"
    //     align = "left"
    //     // Mouse Click Function, default is nothing, look up see the list
    //     onClicked = singleplayer()
    // }
    // button {
    //     position {
    //         x = 190
    //         y = 137
    //     }
    //     width = 100
    //     height = 20
    //     // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
    //     text = literal("Multiplayer")
    //     // The alignment here can be "left", "center" or "right", default is "left"
    //     align = "left"
    //     // Mouse Click Function, default is nothing, look up see the list
    //     onClicked = multiplayer()
    // }
    // button {
    //     position {
    //         x = 190
    //         y = 158
    //     }
    //     width = 100
    //     height = 20
    //     // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
    //     text = literal("Options")
    //     // The alignment here can be "left", "center" or "right", default is "left"
    //     align = "left"
    //     // Mouse Click Function, default is nothing, look up see the list
    //     onClicked = options()
    // }
    // button {
    //     position {
    //         x = 190
    //         y = 179
    //     }
    //     width = 100
    //     height = 20
    //     // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
    //     text = literal("Mods")
    //     // The alignment here can be "left", "center" or "right", default is "left"
    //     align = "left"
    //     // Mouse Click Function, default is nothing, look up see the list
    //     onClicked = modMenu()
    // }
    // button {
    //     position {
    //         x = 190
    //         y = 200
    //     }
    //     width = 100
    //     height = 20
    //     // You can create a text with "literal" or "translatable" if you want to translate with Resource Packs
    //     text = literal("Quit")
    //     // The alignment here can be "left", "center" or "right", default is "left"
    //     align = "left"
    //     // Mouse Click Function, default is nothing, look up see the list
    //     onClicked = exit()
    // }
}