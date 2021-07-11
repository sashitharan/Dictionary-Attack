# Dictionary Attack
An attempt to crack a set of users passwords based on the given shadowfile. 

Passwords hosted from my github through an API: https://my-json-server.typicode.com/sashitharan/dictionaryattack-api-server/db 

The salted passwords look like: 

```
alice:$5$jqcjl$f5f099e0ad6e2f5204688ebe83a59175dda9f1d1b542269fd69f7a8530242495
```

# Analysis

Since each string corresponds to a line in the /etc/shadow file format used in Linux or UNIX- like system to store user credentials in encrypted format, the lines will be easier to interpret out of.

Based on the understanding, we can derive the first 2 fields which are the password and salt with reference to figure 1. The password string can be split according to the format $id$salt$hashed. 

The strings are split into 4 colour codes for better understanding,  it is the username followed by a colon as the fields are separated using a colon (:) symbol. Moving on, the $5$ where it the $id used in the password format on the Linux system to identify the algorithm used. Hence in this case, $5$ reciprocates to a SHA-256 algorithm. Thirdly, the salt used with the original input of the user password to form the hash.

## Execution
The file was tackled using a dictionary attack implemented in Java, with 5 classes, Main.java, ResponseJSON.java, HashUtils.java, AnswerJSON.java and Solutions.java. 

The uploaded JSON file, CrackedPasswords.json, was generated using these classes.

### Dictionary File
As the name of the attack suggests, a file containing a dictionary of words were needed in order to create my set of salted hashes from the dictionary file. The dictionary file was outsourced and the file English.txt was downloaded.

### Gson Library
The third-party library, Gson was used in this program. The Gson library used to assist in facilitating a smooth parsing of the JSON file with the java program. Adding on, the java Class MessageDigest was also used by creating one-way hash functions with the dictionary words and salts with the SHA-256 algorithm. The hash was used in comparison with the provided hashed passwords to decrypt the passwords.

### Consideration for a Rainbow Attack
Hash tables were used to recover as many passwords as possible from the dictionary and in scenarios where passwords are not found, a rainbow table approach will be used to decipher the remaining passwords. However, there wasn’t a need for a rainbow table hence, rainbow table attack was avoided, and the dictionary attack with hash tables was used throughout in this case.

### Final Solution
The final solution of the resolved passwords are attached in the JSON file named CrackedPasswords.json



```json
{
  "passwords": [
    "alice:$5$jqcjl$f5f099e0ad6e2f5204688ebe83a59175dda9f1d1b542269fd69f7a8530242495",
    "bob:$5$nxrhk$54a0beb2f045e3748d9308ad3688bd65ae47206ecca7e449ed13f39f3f6959c7",
    "charlie:$5$vxikt$f60a2d756d2da4eb116de86f07f5cefda7db352bd1573a513e9dbe0633847dd3",
    "david:$5$woyfx$44de4493d577a9dbb8b635c307babbffed20b17f80578eef2416daf721785bb1",
    "eve:$5$soumf$eb206a36b1eda890c29f8f56486ac22f7cce12c50ecf168a4799e05b941b3ef2",
    "fiona:$5$gzavf$2e60ccc3ac57d547358230ad90f33a6fc9508fe1f52762ce8c0460d8cd4211c5",
    "george:$5$ahgyn$8a838aa819f1b52b6b43ef20908ddd18679ec0c8d52e47a2d32f92f79b093224",
    "hannah:$5$bezhm$c99494481a7ef6bf24542e05b5865b389ebd19287b21abc632e34ce95624e25b",
    "iris:$5$hrnwh$fea787874d633c30935d67b1b53d1ab316d7015f332940888d82723699f3779c",
    "jon:$5$pscnx$758fcc3602df54599a2d1bffb69a5c1d06a5c010b6cfd5ab54c8b023f6fc6840",
    "kevin:$5$snkpc$2941cdeea156cd77f36b2d157e469dfa249a199ef8fb2ae12926157244064ae6",
    "leila:$5$mcfmf$ebae93e36fa2211746c24d897656999153a62d43f302e999bc6a1a7d51993de5",
    "mo:$5$ppedi$ce3ee2cb1296952f275f2fdda498cc0d4f8f6777449b39970a16e62eeb4f9361",
    "nadine:$5$yhmlt$862b17460e56e4a0987f294f46db47142f77fb81a1eae8c136acd46b41ced62b",
    "olga:$5$kzrke$1175be50a421a02f6951af4f72a6583b39eaad0dad11c72db3023ea69bf67d1c",
    "paul:$5$txypw$75694096fb9003c208c7cbbedba0cc4df5b0c6ea0365a41fff8d2ff7a74a3995",
    "quinn:$5$leytk$55791a6fda3d86b06db2f911fb670241a1731f7c17f347e34e0066b65ac0ef33",
    "rose:$5$ldnzm$e418f132f9a74469e90d634647eddc281f57bc8218d6cd4bd03a60dfb94c4cd4",
    "sophie:$5$zmixa$eb7f72e9c44f667d25e1577be4ee5e4e49444e4465a4a6926f9566bbe9a7f5c5",
    "tom:$5$rsucu$435e6bd28742902e0c17bfde7172e064eb2805c2f0e1cc24c03fb6b6415838a5",
    "ursula:$5$sahvw$473a0f4f6350c44e8e217dd69e82408ee46cde73605b7c848acc8c062bc54213",
    "viola:$5$pvkag$4374b9511cb4448bb5a828d107e4f389f5ba753467958e7781cc77d199a64eaf",
    "wade:$5$updmb$51b578eea71d5c43f65b176490c844b6f9bea3e264a12d47fb95e445c58924b8",
    "xavier:$5$goqll$51f5fcce40378492b1c67a8430d677aa6f9de0d247e14ac10f8bfff0caad5770",
    "yasmin:$5$qoywq$a7242c87a689f5eae6327157c0892187ce16ed0860cb5a98483c25f3517d8dcf",
    "zac:$5$omibc$5b4eca0e99bbf11867ef299e1764d3fc7df3084a36b0fcccd2956d34dd7bc8b6"
  ],
  "solutions": {
    "alice": {
      "password": "zeppelin",
      "salt": "jqcjl"
    },
    "bob": {
      "password": "polynomial",
      "salt": "nxrhk"
    },
    "charlie": {
      "password": "knowledge",
      "salt": "vxikt"
    },
    "david": {
      "password": "structure",
      "salt": "woyfx"
    },
    "eve": {
      "password": "happens",
      "salt": "soumf"
    },
    "fiona": {
      "password": "general",
      "salt": "gzavf"
    },
    "george": {
      "password": "happiness",
      "salt": "ahgyn"
    },
    "hannah": {
      "password": "feature",
      "salt": "bezhm"
    },
    "iris": {
      "password": "access",
      "salt": "hrnwh"
    },
    "jon": {
      "password": "keywords",
      "salt": "pscnx"
    },
    "kelvin": {},
    "leila": {
      "password": "keyboard",
      "salt": "mcfmf"
    },
    "mo": {
      "password": "yachting",
      "salt": "ppedi"
    },
    "nadine": {
      "password": "gallery",
      "salt": "yhmlt"
    },
    "olga": {
      "password": "technical",
      "salt": "kzrke"
    },
    "paul": {
      "password": "calculator",
      "salt": "txypw"
    },
    "quinn": {
      "password": "traveling",
      "salt": "leytk"
    },
    "rose": {
      "password": "candidate",
      "salt": "ldnzm"
    },
    "sophie": {
      "password": "philosophy",
      "salt": "zmixa"
    },
    "tom": {
      "password": "yesterday",
      "salt": "rsucu"
    },
    "ursula": {
      "password": "icebreaker",
      "salt": "sahvw"
    },
    "viola": {
      "password": "technology",
      "salt": "pvkag"
    },
    "wade": {
      "password": "experiment",
      "salt": "updmb"
    },
    "xavier": {
      "password": "values",
      "salt": "goqll"
    },
    "yasmin": {
      "password": "character",
      "salt": "qoywq"
    },
    "zac": {
      "password": "literature",
      "salt": "omibc"
    }
  }
}

```
