module ethan.cs1622.pokemonshowdown {
    requires javafx.controls;
    requires javafx.fxml;


    opens ethan.cs1622.pokemonshowdown to javafx.fxml;
    exports ethan.cs1622.pokemonshowdown;
}