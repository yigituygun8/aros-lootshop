# 🎮 AROS Loot Shop

> A game loot shop simulation with GUI, where users can browse and purchase various items such as weapons, armor, and potions. Admins can also add new items to the shop inventory.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Course](https://img.shields.io/badge/Course-CTIS221-blue?style=for-the-badge)

---

## 👥 Team Members

| Name | Alias |
|------|-------|
| **Arda Planalı** | AR |
| **Osman Yiğit Uygun** | OS |
| **Gökşin Özdinç** | IN OUR HEARTS 💜 |

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher installed on your system

### Running the Application
1. Clone or download this repository
2. Run the JAR file:
   ```bash
   java -jar Aros_LootShop_DEMO.jar
   ```
   Or simply double-click on `Aros_LootShop_DEMO.jar`

---

## 🔐 Admin Panel Access (Secret Passage)

| Password | `goksin` |
|----------|----------|
| **Note** | All lowercase, we love Gökşin! 💜 |

### How to Access:
1. Click **"To The Secret Passage"** button in the Lobby
2. Enter the password and press Enter or click the button

---

## 📁 Project Structure

```
src/
├── 🖼️ GUI/                         # GUI Classes
│   ├── LobbyFrame.java             # Main menu screen
│   ├── ShoppingFrame.java          # Customer shopping interface
│   ├── PurchaseFrame.java          # Purchase completion screen
│   ├── AdminBridgePswd.java        # Password authentication for admin
│   └── AdminPanelFrame.java        # Admin inventory management panel
│
├── 📋 interfaces/                  # Interface Definition
│   └── Purchasable.java            # Interface for purchasable items
│
├── 📦 products/                    # Product Classes
│   ├── ShopItem.java               # Abstract base class for all items
│   ├── Weapon.java                 # Weapon product (extends ShopItem)
│   ├── Armor.java                  # Armor product (extends ShopItem)
│   ├── Potion.java                 # Potion product (extends ShopItem)
│   └── Stats.java                  # Stats for Weapons and Armor
│
└── 🏪 shop/                        # Shop Logic
    ├── shopMain.java               # Entry point (main method)
    └── ArosShop.java               # Core shop operations
```

---

## ⚔️ Item Types & Attributes

### 🗡️ Weapon
| Attribute | Description |
|-----------|-------------|
| ID, Name, Base Price | Basic info |
| Rarity, Quantity | Stock info |
| Damage | Weapon-specific |
| Stats | Status, Durability, Weight, isMagical |

### 🛡️ Armor
| Attribute | Description |
|-----------|-------------|
| ID, Name, Base Price | Basic info |
| Rarity, Quantity | Stock info |
| Defence, Material | Armor-specific |
| Stats | Status, Durability, Weight, isMagical |

### 🧪 Potion
| Attribute | Description |
|-----------|-------------|
| ID, Name, Base Price | Basic info |
| Rarity, Quantity | Stock info |
| Effect, Duration | Potion-specific |
| isHazardous, isThrowable | Special flags |

---

## 📊 Valid Values

| Category | Options |
|----------|---------|
| **Rarity Levels** | `Mythic`, `Epic`, `Common` |
| **Status Options** | `New`, `Field Tested`, `Battle Scarred` |
| **Durability Levels** | `Low`, `Medium`, `High` |

> ⚠️ Please enter values exactly as shown when adding items

---

## 📄 Data File Format (`products.txt`)

Initial products are loaded from `products.txt` using `*` as delimiter.

### Weapon Format:
```
Weapon*ID*Name*Base_Price*Rarity*Quantity*Damage*Status*Durability*Weight*isMagical
```

### Armor Format:
```
Armor*ID*Name*Base_Price*Rarity*Quantity*Defence*Material*Status*Durability*Weight*isMagical
```

### Potion Format:
```
Potion*ID*Name*Base_Price*Rarity*Quantity*Effect*Duration*isHazardous*isThrowable
```

---

## 🗺️ Navigation Flow

```
                    ┌─────────────────┐
                    │  AdminPanelFrame │
                    └────────▲────────┘
                             │
                    ┌────────┴────────┐
                    │ AdminBridgePswd  │
                    └────────▲────────┘
                             │
┌──────────┐        ┌────────┴────────┐        ┌───────────────┐
│  EXIT    │◄───────│     LOBBY       │───────►│ ShoppingFrame │
└──────────┘        └─────────────────┘        └───────┬───────┘
                                                       │
                                                       ▼
                                               ┌───────────────┐
                                               │ PurchaseFrame │
                                               └───────────────┘
```

---

## 📜 License

This project was created as part of the CTIS221 course at Bilkent University.

---

<p align="center">Made with ❤️ by Team AROS</p>
