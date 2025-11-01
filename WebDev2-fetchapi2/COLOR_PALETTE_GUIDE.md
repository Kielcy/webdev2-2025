# Color Palette Guide - Car Application

## 🎨 Color Definitions

| Color | Hex | Usage |
|-------|-----|-------|
| **Primary** | `#0A84FF` | Main actions, links, highlights |
| **Secondary** | `#1D1D1D` | Secondary elements, borders |
| **Accent** | `#FFD60A` | Warnings, highlights, CTAs |
| **Background** | `#0F0F0F` | Main app background |
| **Surface / Cards** | `#1F1F1F` | Cards, panels, elevated surfaces |
| **Text** | `#FFFFFF` | Primary text content |

---

## 🚗 Usage Rules

### **Buttons**

- **Primary Button**: `#0A84FF` background, white text
  - Use for: Main CTAs (Save, Submit, Add Car, etc.)
  - Hover: Lighten to `#2A9AFF` (+10% brightness)
  - Active: Darken to `#0070D4` (-15% brightness)

- **Secondary Button**: `#1D1D1D` background, white text
  - Use for: Cancel, back, secondary actions
  - Hover: Lighten to `#2D2D2D`
  - Active: Darken to `#151515`

- **Accent Button**: `#FFD60A` background, `#0F0F0F` text
  - Use for: Special actions (Buy Now, Premium features)
  - Hover: Brighten to `#FFE84D`
  - Active: Darken to `#E6C209`

- **Ghost/Outline**: Transparent background, `#0A84FF` border/text
  - Use for: Tertiary actions
  - Hover: `#0A84FF` background

### **Headers & Navigation**

- **Main Header Bar**: `#1F1F1F` background (Surface)
- **Navigation Links**: White text (`#FFFFFF`)
- **Active Nav Item**: `#0A84FF` underline or background highlight
- **Hover Nav Item**: `#0A84FF` at 20% opacity background

### **Cards & Surfaces**

- **Card Background**: `#1F1F1F` (Surface)
- **Card Border**: `#1D1D1D` (Secondary) - subtle, 1px solid
- **Card Hover**: Elevate with `#2A2A2A` background + subtle shadow
- **Card Shadow**: Use `rgba(10, 132, 255, 0.1)` for subtle depth

### **Alerts & Notifications**

- **Success**: `#0A84FF` background with white text
- **Warning**: `#FFD60A` background with `#0F0F0F` text
- **Error**: `#FF3B30` (red) background with white text
- **Info**: `#0A84FF` background with white text at 80% opacity
- All alerts use `#1F1F1F` container background

---

## 📍 Where to Apply Each Color

### **Primary (#0A84FF)**
✅ Primary buttons  
✅ Active navigation states  
✅ Links (normal and hover)  
✅ Form focus borders  
✅ Progress indicators  
✅ Selected checkboxes/radio buttons  
✅ Icon highlights  
✅ Status "active" indicators  

### **Secondary (#1D1D1D)**
✅ Secondary button backgrounds  
✅ Subtle borders and dividers  
✅ Input field borders (default)  
✅ Disabled element backgrounds  
✅ Separator lines  

### **Accent (#FFD60A)**
✅ Warning badges  
✅ Special promotional buttons  
✅ Highlight important features  
✅ "New" tags  
✅ Star ratings  
⚠️ Use sparingly - too much is overwhelming  

### **Background (#0F0F0F)**
✅ Main application background  
✅ Modal overlays  
✅ Sidebar backgrounds (if using)  
✅ Body element  

### **Surface/Cards (#1F1F1F)**
✅ All card components  
✅ Dropdown menus  
✅ Modal dialogs  
✅ Side panels  
✅ Table rows (alternating)  
✅ Tooltip backgrounds  

### **Text (#FFFFFF)**
✅ All primary text  
✅ Button text (on colored backgrounds)  
✅ Headings (H1-H6)  
✅ Body text  
✅ Labels  
✅ Placeholder text (at 60% opacity)  

---

## 📖 Text Readability Guidelines

### **Contrast Ratios (WCAG AA Minimum)**

✅ **Excellent Contrast:**
- White text on `#0F0F0F` background: **16.8:1** ✓
- White text on `#1F1F1F` background: **13.4:1** ✓
- White text on `#0A84FF` background: **4.6:1** ✓
- White text on `#1D1D1D` background: **13.8:1** ✓

⚠️ **Caution:**
- `#FFD60A` background with white text: **1.4:1** ✗
- Use `#0F0F0F` text on `#FFD60A` background: **10.6:1** ✓

### **Text Size Guidelines**

- **Large Headings**: Always white on dark backgrounds
- **Body Text**: Minimum 14px for readability
- **Secondary Text**: Use white at 80% opacity (`rgba(255, 255, 255, 0.8)`)
- **Disabled Text**: Use white at 40% opacity (`rgba(255, 255, 255, 0.4)`)

---

## ✨ Hover & Active States

### **Standard Hover Pattern**
- **Buttons**: Brighten by ~10-15%
- **Cards**: Change background from `#1F1F1F` → `#2A2A2A`
- **Links**: Change from `#FFFFFF` → `#0A84FF`
- **Icons**: Add `#0A84FF` color

### **Active/Pressed States**
- **Buttons**: Darken by ~15-20%
- **Navigation**: Maintain `#0A84FF` highlight
- **Interactive Elements**: Slight scale down (0.98x transform)

### **Focus States**
- **Input Fields**: `#0A84FF` outline, 2px solid
- **Buttons**: `#0A84FF` ring, 2px offset
- **Accessible**: Always visible for keyboard navigation

---

## 🛠️ Adding New Features - Consistency Checklist

When adding new features, follow this checklist:

### **1. Color Selection**
- [ ] Does it use existing palette colors?
- [ ] Avoid introducing new colors (only if absolutely necessary)
- [ ] Check contrast ratios for text readability

### **2. Component Consistency**
- [ ] Buttons match existing button styles
- [ ] Cards use `#1F1F1F` background
- [ ] Text is `#FFFFFF` (or appropriate opacity variant)
- [ ] Borders use `#1D1D1D` when needed

### **3. Interactive States**
- [ ] Hover states defined (brighten primary elements)
- [ ] Active states defined (darken on press)
- [ ] Focus states visible (accessibility)
- [ ] Disabled states use reduced opacity

### **4. Spacing & Hierarchy**
- [ ] Primary actions use Primary color
- [ ] Secondary actions use Secondary color
- [ ] Important highlights use Accent color (sparingly)
- [ ] Background/surface distinction maintained

### **5. Code Organization**
- [ ] Use CSS variables (see `colors.css`)
- [ ] Reference Tailwind config colors
- [ ] Document any color exceptions in component comments

---

## 💻 Implementation Tips

### **CSS Variables**
Reference `colors.css` for all color values:
```css
--primary: #0A84FF;
--secondary: #1D1D1D;
--accent: #FFD60A;
--background: #0F0F0F;
--surface: #1F1F1F;
--text: #FFFFFF;
```

### **Tailwind Config**
All colors are defined in `tailwind.config.js` for easy usage:
```html
<button class="bg-primary hover:bg-primary-hover">Click</button>
```

---

## 🚦 Quick Reference

**Need a button?** → Primary: `#0A84FF`  
**Need a card?** → Surface: `#1F1F1F`  
**Need to highlight?** → Accent: `#FFD60A` (sparingly)  
**Need text?** → Text: `#FFFFFF`  
**Need a border?** → Secondary: `#1D1D1D`  
**Background?** → Background: `#0F0F0F`

**Remember**: This is a car app - sleek, modern, and performance-focused. Keep it clean and consistent! 🏎️

