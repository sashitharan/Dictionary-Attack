# Dictionary Attack
An attempt to crack a set of users passwords based on the given shadowfile. 

Passwords hosted from my github through an API: https://my-json-server.typicode.com/sashitharan/dictionaryattack-api-server/db 

The salted passwords look like: 

```
alice:$5$jqcjl$f5f099e0ad6e2f5204688ebe83a59175dda9f1d1b542269fd69f7a8530242495
```

# Analysis

Since each string corresponds to a line in the /etc/shadow file format used in Linux or UNIX- like system to store user credentials in encrypted format, the lines will be easier to interpret out of.

Based on the understanding, we can derive the first 2 fields which are the password and salt with reference to figure 1. As mentioned in Gite’s article (2020), it can be referred that the password string can be split according to the format $id$salt$hashed. 

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
