#ifndef SECRETS_H
#define SECRETS_H

#include <string>
#include <map>

class Secrets {
public:
    // Constructor
    Secrets();

    // Getter method to get a value corresponding to a given key from config.properties
    std::string get(const std::string& key);

private:
    std::map<std::string, std::string> prop; // Map to store key-value pairs from config.properties
};

#endif // SECRETS_H