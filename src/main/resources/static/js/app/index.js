function substituteOnClick() {

        if ($("#users").css( "display") == "block" ) {
            $("#users").css( "display", "none" );
            $("#thonlick").html('SHOW USERS');
        }
        else{
            $("#users").css( "display", "block" );
            $("#thonlick").html('HIDE USERS');
        }
}