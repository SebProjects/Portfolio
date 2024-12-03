from pathlib import Path

ROOT_PATH = "/Users/seb/Desktop/python/data"

musique_dir = ROOT_PATH + "/Musique"
videos_dir = ROOT_PATH + "/Videos"
images_dir = ROOT_PATH + "/Images"
documents_dir = ROOT_PATH + "/Documents"
divers_dir = ROOT_PATH + "/Divers"


p_root = Path(ROOT_PATH)

p_musique = Path(musique_dir)
p_videos = Path(videos_dir)
p_images = Path(images_dir)
p_documents = Path(documents_dir)
p_divers = Path(divers_dir)

p_musique.mkdir(parents=True, exist_ok=True)
p_videos.mkdir(parents=True, exist_ok=True)
p_images.mkdir(parents=True, exist_ok=True)
p_documents.mkdir(parents=True, exist_ok=True)
p_divers.mkdir(parents=True, exist_ok=True)

for child in p_root.iterdir():
        if child.match('*.wav') or child.match('*.mp3') or child.match('*.flac'):
                print(f"Deplacement du fichier : { child.name } vers le dossier { musique_dir }")
                child.replace(p_musique.joinpath(child.name))
        elif child.match('*.avi') or child.match('*.mp4') or child.match('*.gif'):
                print(f"Deplacement du fichier : { child.name } vers le dossier { videos_dir }")
                child.replace(p_videos.joinpath(child.name))
        elif child.match('*.bmp') or child.match('*.png') or child.match('*.jpg'):
                print(f"Deplacement du fichier : { child.name } vers le dossier { images_dir }")
                child.replace(p_images.joinpath(child.name))
        elif child.match('*.txt') or child.match('*.pptx') or child.match('*.xls') or child.match('*.odp') or child.match('*.pages') or child.match('*.csv'):
                print(f"Deplacement du fichier : { child.name } vers le dossier { documents_dir }")
                child.replace(p_documents.joinpath(child.name))
        elif child.match('*.*'):
                print(f"Deplacement du fichier : { child.name } vers le dossier { divers_dir }")
                child.replace(p_divers.joinpath(child.name))
