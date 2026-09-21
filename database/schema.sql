-- InstaCar database foundation
create table if not exists profiles (
  id uuid primary key,
  username varchar(30) unique not null,
  display_name varchar(80),
  bio varchar(160),
  avatar_url text,
  created_at timestamptz default now()
);

create table if not exists cars (
  id uuid primary key,
  owner_id uuid not null references profiles(id) on delete cascade,
  brand varchar(60),
  model varchar(60),
  year integer,
  engine varchar(80),
  description text,
  created_at timestamptz default now()
);

create table if not exists posts (
  id uuid primary key,
  author_id uuid not null references profiles(id) on delete cascade,
  caption text,
  media_url text,
  car_id uuid references cars(id) on delete set null,
  created_at timestamptz default now()
);

create table if not exists likes (
  post_id uuid references posts(id) on delete cascade,
  user_id uuid references profiles(id) on delete cascade,
  created_at timestamptz default now(),
  primary key(post_id,user_id)
);

create table if not exists comments (
  id uuid primary key,
  post_id uuid references posts(id) on delete cascade,
  user_id uuid references profiles(id) on delete cascade,
  body text not null,
  created_at timestamptz default now()
);

create table if not exists follows (
  follower_id uuid references profiles(id) on delete cascade,
  following_id uuid references profiles(id) on delete cascade,
  created_at timestamptz default now(),
  primary key(follower_id,following_id),
  check(follower_id <> following_id)
);
