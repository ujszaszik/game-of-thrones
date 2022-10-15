package hu.ujszaszik.characters.shared.remote

internal val fakeCharacterResponses = listOf(
    CharacterResponse(
        id = 1,
        firstName = "First",
        lastName = "Character",
        fullName = "First Character",
        title = "Testing Character",
        family = "Testing Family",
        image = "first.png",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vZmlyc3QucG5n"
    ),
    CharacterResponse(
        id = 2,
        firstName = "Second",
        lastName = "Character",
        fullName = "Second Character",
        title = "Another Testing Character",
        family = "Another Testing Family",
        image = "second.png",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vc2Vjb25kLnBuZw=="
    ),
    CharacterResponse(
        id = 3,
        firstName = "Third",
        lastName = "Character",
        fullName = "Third Character",
        title = "Yet Another Testing Character",
        family = "Yet Another Testing Family",
        image = "third.png",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vdGhpcmQucG5n"
    )
)