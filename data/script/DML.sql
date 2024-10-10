DELETE FROM products;
DELETE FROM orders;
DELETE FROM users;

INSERT INTO users (user_name, email, user_password, admin_role) VALUES 
('Jhon Do', 'email@mail.com', '1234', false),
('admin','admin@mail.com', 'admin', true),
('toto','admin@mail.com', 'tata', true),
('foo bar','foobar@mail.com','azerty', false);


INSERT INTO orders (product_name, user_id) VALUES 
('teddy bear', (SELECT id FROM users WHERE user_name = 'Jhon Do')),
('book', (SELECT id FROM users WHERE user_name = 'Jhon Do')),
('rise cooker', (SELECT id FROM users WHERE user_name = 'toto')),
('shoes',(SELECT id FROM users WHERE user_name = 'Jhon Do')),
('sun glasses',(SELECT id FROM users WHERE user_name = 'toto')),
('desk',(SELECT id FROM users WHERE user_name = 'Jhon Do')),
('keyboard',(SELECT id FROM users WHERE user_name = 'toto'));


INSERT INTO products (product_name, description, price) VALUES
('teddy bear', 'your best friend', 39.99),
('wooden chair', 'sturdy and elegant for your home', 59.99),
('coffee mug', 'start your day with a perfect sip', 12.99),
('desk lamp', 'brighten your workspace', 24.99),
('leather wallet', 'stylish and durable for everyday use', 49.99),
('stainless steel water bottle', 'keep drinks cool or hot all day', 19.99),
('wireless headphones', 'immersive sound without wires', 89.99),
('gaming keyboard', 'perfect precision for gamers', 79.99),
('smartphone case', 'protect your phone in style', 14.99),
('scented candle', 'relax with calming fragrances', 15.99),
('yoga mat', 'cushion and comfort for every pose', 29.99),
('backpack', 'versatile for work, school, or travel', 54.99),
('Bluetooth speaker', 'portable music with powerful sound', 69.99),
('running shoes', 'comfort and support for active lifestyles', 99.99),
('wristwatch', 'classic design, timeless appeal', 129.99),
('kitchen knife set', 'precision blades for culinary excellence', 89.99),
('portable charger', 'never run out of battery on the go', 29.99),
('fitness tracker', 'track your activity and stay healthy', 59.99),
('laptop stand', 'ergonomic design for better posture', 34.99),
('plush blanket', 'super soft and cozy for relaxing', 49.99),
('ceramic vase', 'modern design for any interior', 24.99),
('sunglasses', 'stylish protection from the sun', 19.99),
('electric toothbrush', 'advanced cleaning for a bright smile', 79.99),
('wireless mouse', 'smooth control without the cord', 25.99),
('noise-cancelling earplugs', 'block out unwanted sounds', 14.99),
('travel pillow', 'comfort on every journey', 19.99),
('electric kettle', 'quick and efficient boiling', 39.99),
('puzzle game', 'challenge your mind with intricate designs', 16.99),
('tabletop plant', 'bring nature indoors with minimal care', 18.99),
('facial skincare set', 'nourish and hydrate your skin', 45.99),
('laptop backpack', 'padded for electronics and essentials', 69.99),
('picnic basket', 'all-in-one for outdoor dining', 49.99),
('drone', 'capture stunning aerial footage', 299.99),
('fountain pen', 'write with elegance and precision', 24.99),
('vinyl record player', 'retro sound for music lovers', 89.99),
('board game', 'fun for family and friends', 39.99),
('chef’s apron', 'stylish protection for every cook', 19.99),
('digital photo frame', 'display your memories with ease', 79.99),
('camping tent', 'sturdy shelter for outdoor adventures', 119.99),
('fleece jacket', 'lightweight warmth for cold weather', 59.99),
('smart doorbell', 'see and communicate with visitors', 149.99),
('wireless charger', 'fast charging without cables', 34.99),
('electric scooter', 'commute in style with zero emissions', 499.99),
('kids’ building blocks', 'creative playtime for little engineers', 29.99),
('robot vacuum', 'hands-free cleaning for your home', 299.99),
('bike helmet', 'safety meets style for cyclists', 45.99),
('LED desk light', 'adjustable lighting for any task', 39.99),
('suitcase', 'durable and spacious for all travels', 129.99),
('air purifier', 'breathe cleaner, healthier air', 199.99),
('guitar', 'make music with this classic instrument', 249.99);

SELECT * FROM products;